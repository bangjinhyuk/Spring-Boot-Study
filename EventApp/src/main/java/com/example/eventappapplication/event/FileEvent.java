package com.example.eventappapplication.event;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
@Getter
@Builder
public class FileEvent {
    private String eventId;
    private String type;
    private Map<String,Object> data;

    public static FileEvent toCompleteEvent(Map data){
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPLETE.name())
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map data){
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.ERROR.name())
                .data(data)
                .build();
    }
}
