package com.mohsin.lld.ratelimiter.v2;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimitingInterceptor extends HandlerInterceptorAdapter {
 
    private static final Logger logger = LoggerFactory.getLogger(RateLimitingInterceptor.class);
     
    @Value("${rate.limit.enabled}")
    private boolean enabled;
     
    @Value("${rate.limit.hourly.limit}")
    private int hourlyLimit;
 
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
 
    private Map<String, Optional<SimpleRateLimiter>> limiters = new ConcurrentHashMap<>();
     
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!enabled) {
            return true;
        }
        String clientId = request.getHeader("Client-Id");
        // let non-API requests pass
        if (clientId == null) {
            return true;
        }
        SimpleRateLimiter rateLimiter = getRateLimiter(clientId);
        boolean allowRequest = limiter.tryAcquire();
     
        if (!allowRequest) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        response.addHeader("X-RateLimit-Limit", String.valueOf(hourlyLimit));
        return allowRequest;
    }
     
    private SimpleRateLimiter getRateLimiter(String clientId) {
        return limiters.computeIfAbsent(clientId, clientId -> {
            return Optional.of(createRateLimiter(clientId));
        });
    }
 
    private SimpleRateLimiter createRateLimiter(String applicationId) {
        logger.info("Creating rate limiter for applicationId={}", applicationId);
        return SimpleRateLimiter.create(hourlyLimit, TimeUnit.HOURS, scheduler, applicationId);
    }
 
     
    @PreDestroy
    public void destroy() {
        // loop and finalize all limiters
        scheduler.shutdown();
    }
}