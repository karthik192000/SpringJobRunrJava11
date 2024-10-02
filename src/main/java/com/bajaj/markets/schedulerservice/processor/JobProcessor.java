package com.bajaj.markets.schedulerservice.processor;


import com.bajaj.markets.schedulerservice.bean.EventBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobProcessor {





//    @Autowired
//    PublisherService publisherService;


    public void delegateEvent(EventBean eventBean){
        String eventType = eventBean.getEventType();
        Object payload = eventBean.getPayload();
//        EventMessage eventMessage = new EventMessage();
        Map<String,String> messageFilterAttributes = new HashMap<>();
        messageFilterAttributes.put("eventType",eventType);
//        eventMessage.setPayload(payload);
//        eventMessage.setMessageFilterAttributes(messageFilterAttributes);
//        PublishResult publishResult = publisherService.publish("topicname",eventMessage);
    }
}
