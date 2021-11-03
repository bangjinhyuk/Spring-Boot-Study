package com.example.eventappapplication.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
@Slf4j
@Component
public class FileEventListener {
    @EventListener
    public void onFileEventHandler(FileEvent fileEvent){
        log.info("fileevent receive type:{} data:{}",fileEvent.getType(),fileEvent.getData());
        // 파일 타입에 따리 어떠한 추가적인 작업을 할수 있다.
    }
}
