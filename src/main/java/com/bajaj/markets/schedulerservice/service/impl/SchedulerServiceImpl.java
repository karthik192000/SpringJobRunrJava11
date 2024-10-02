package com.bajaj.markets.schedulerservice.service.impl;

import com.bajaj.markets.schedulerservice.bean.EventBean;
import com.bajaj.markets.schedulerservice.processor.JobProcessor;
import com.bajaj.markets.schedulerservice.service.SchedulerService;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class SchedulerServiceImpl implements SchedulerService {


    @Autowired
    private JobProcessor jobProcessor;


    @Autowired
    JobScheduler jobScheduler;



    @Override
    public void schedule(EventBean eventBean) {
       jobScheduler.schedule(Instant.now().plus(30, ChronoUnit.SECONDS), () -> jobProcessor.delegateEvent(eventBean));
    }
}
