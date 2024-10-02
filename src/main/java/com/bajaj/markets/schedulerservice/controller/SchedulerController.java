package com.bajaj.markets.schedulerservice.controller;


import com.bajaj.markets.schedulerservice.bean.EventBean;
import com.bajaj.markets.schedulerservice.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
public class SchedulerController {


    @Autowired
    SchedulerService service;


    @PostMapping(path = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void schedule(@RequestBody EventBean eventBean){
        service.schedule(eventBean);
    }



}
