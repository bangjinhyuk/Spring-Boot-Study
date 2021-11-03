package com.example.eventappapplication.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangjinhyuk on 2021/11/03.
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/upload/image")
    public ResponseEntity fileUpload(){
        Map<String,Object> data = new HashMap<>();
        data.put("userId","홍길동");
        data.put("type","webp");
        data.put("fileSize",5);

        fileService.fileUpload(data);

        return ResponseEntity.ok("success");

    }

}
