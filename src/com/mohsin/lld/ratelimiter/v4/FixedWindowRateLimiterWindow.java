package com.mohsin.lld.ratelimiter.v4;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedWindowRateLimiterWindow implements RateLimiter {

    /*
Synchronizing Strings
It is not recommended to use objects which are pooled and reused, if you do so there is a chance of getting into deadlock condition down the line.

Since Strings are pooled in String constant pool and reused, it is not suggestable lock String types with Synchronization.

String intern
https://www.journaldev.com/7929/java-string-intern
https://www.baeldung.com/java-synchronization-bad-practices
https://dzone.com/articles/synchronized-by-the-value-of-the-object-in-java
https://dzone.com/articles/how-concurrenthashmap-works-internally-in-java#:~:text=Part%20of%20the%20map%20called,was%20introduced%20to%20improve%20performance.

 */


    TimeWindow timeWindow;
    Integer limit;

    // this is needed. even though we are using synchronised while doing operations in 'map', two map.put operations for
    // the same bucket can happen together (in case if different eids having same bucket in the hashtable)
    // to deal with that we need ConcurrentHashMap
    ConcurrentHashMap<String, WindowDetail> eidToWindowDetailMap;

    // this is used since it's not recommended to have lock on Strings in literal as they are pooled from global source
    ConcurrentHashMap<String, Object> lockMap;

    private static class WindowDetail {

        long timeStamp;
        int count;
    }

    public FixedWindowRateLimiterWindow(TimeWindow timeWindow, Integer limit) {
        this.timeWindow = timeWindow;
        this.limit = limit;
        eidToWindowDetailMap = new ConcurrentHashMap<>();
        lockMap = new ConcurrentHashMap<>();

        // ****** check all the syntaxes
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Cleaner(), 1, timeWindow.timeUnit.toMillis(2 * timeWindow.no), TimeUnit.MILLISECONDS);
    }


    // ****** check all the syntaxes
    private class Cleaner implements Runnable {

        public void run() {
            Iterator<Entry<String, WindowDetail>> iterator = eidToWindowDetailMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, WindowDetail> next = iterator.next();
                WindowDetail value = next.getValue();
                if (System.currentTimeMillis() - value.timeStamp > timeWindow.timeUnit.toMillis(timeWindow.no)) {
                    iterator.remove();
                    lockMap.remove(next.getKey());
                }
            }
        }
    }


    @Override
    public boolean check(String eid) {

        //    see declaration for explanation
        lockMap.putIfAbsent(eid, new Object());

        //   see declaration for explanation
        synchronized (lockMap.get(eid)) {
            WindowDetail windowDetail = eidToWindowDetailMap.get(eid);
            long curMills = System.currentTimeMillis();
            if (windowDetail == null) {
                windowDetail = new WindowDetail();
                windowDetail.count = 1;
                windowDetail.timeStamp = curMills;
                eidToWindowDetailMap.put(eid, windowDetail);
                return true;
            } else {
                if (curMills - windowDetail.timeStamp > timeWindow.timeUnit.toMillis(timeWindow.no)) {
                    windowDetail = new WindowDetail();
                    windowDetail.count = 1;
                    windowDetail.timeStamp = curMills;
                    eidToWindowDetailMap.put(eid, windowDetail);
                    return true;
                } else {
                    if (windowDetail.count < limit) {
                        windowDetail.count = windowDetail.count + 1;
                        eidToWindowDetailMap.put(eid, windowDetail);
                        return true;
                    } else {
                        return false;
                    }

                }
            }
        }
    }
}
