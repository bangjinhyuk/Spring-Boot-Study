package com.example.eventappapplication.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */

@Component
public class FileEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void notifyComplete(FileEvent fileEvent){
        applicationEventPublisher.publishEvent(fileEvent);
    }
    public void notifyError(FileEvent fileEvent){
        applicationEventPublisher.publishEvent(fileEvent);
    }
}
