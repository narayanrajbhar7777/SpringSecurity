package com.caching.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
    int i = 1;

    // fixed period of time it will call
    @Scheduled(fixedRate = 5_000)
    public void cleanTempFile() {
        log.info("cleanTempFile(): " + (System.currentTimeMillis() / 1000));
    }

    //last task execution after it, this will call
    @Scheduled(fixedDelay = 5_000)
    public void cleanLog() {
        log.info("cleanLog(): " + i);
    }

    //Seconds Minutes Hours DayOfMonth Month DayOfWeek
    @Scheduled(cron = "0 0 12 * * ?")
    //this will execute every-day at 12 PM
    public void cleanWeeklyLog() {
        log.info("cleanWeeklyLog(): "+i);
    }
}
