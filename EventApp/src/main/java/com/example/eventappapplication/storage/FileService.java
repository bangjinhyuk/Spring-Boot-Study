package com.example.eventappapplication.storage;

import com.example.eventappapplication.event.FileEvent;
import com.example.eventappapplication.event.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {
    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data){
        try{
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            FileEvent completeEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        }catch (Exception e){
            log.error("file upload dail", e);
            FileEvent errorEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyError(errorEvent);

        }



    }


}
