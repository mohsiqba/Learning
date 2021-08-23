package com.mohsin.lld.ratelimiter.v4;

public interface RateLimiter {

    boolean check(String eid);
}