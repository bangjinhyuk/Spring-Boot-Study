package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
@Slf4j
@Service
public class RestTemplateService {

//    public String hello(){
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/hello")
//                .encode()
//                .build()
//                .toUri();
//
//        log.info("made uri : {}", uri.toString());
//        RestTemplate restTemplate = new RestTemplate();
//
////        return restTemplate.getForObject(uri, String.class); // 1번 방법
//
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri,String.class); //2번 entity 방식
//        log.info("result status code: {}",responseEntity.getStatusCode());
//        log.info("result : {}",responseEntity.getBody());
//
//        return responseEntity.getBody();
//    }

    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age",10)
                .encode()
                .build()
                .toUri();

        log.info("made uri : {}", uri.toString());
        RestTemplate restTemplate = new RestTemplate();

//        return restTemplate.getForObject(uri, String.class); // 1번 방법

        ResponseEntity<UserResponse> responseEntity = restTemplate.getForEntity(uri,UserResponse.class); //2번 entity 방식
        log.info("result status code: {}",responseEntity.getStatusCode());
        log.info("result : {}",responseEntity.getBody());

        return responseEntity.getBody();
    }

    public UserResponse hi(){ //post
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hi/{userId}")
                .encode()
                .build()
                .expand(100) // userId 순서대로 추가하면 들어감
                .toUri();


        log.info("made uri : {}", uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        UserRequest req = new UserRequest("nbnad",123);


        ResponseEntity<UserResponse> responseEntity = restTemplate.postForEntity(uri,req,UserResponse.class);
        log.info("result status code: {}",responseEntity.getStatusCode());
        log.info("result Header : {}",responseEntity.getHeaders());
        log.info("result : {}",responseEntity.getBody());

        return responseEntity.getBody();
    }

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hi2/{userId}")
                .encode()
                .build()
                .expand(100) // userId 순서대로 추가하면 들어감
                .toUri();


        log.info("made uri : {}", uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        UserRequest req = new UserRequest("nbnad",123);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","dddd")
                .body(req);

        ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(requestEntity, UserResponse.class);
        log.info("result status code: {}",responseEntity.getStatusCode());
        log.info("result Header : {}",responseEntity.getHeaders());
        log.info("result : {}",responseEntity.getBody());

        return responseEntity.getBody();

    }

    public Req<UserResponse> genericExchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hi3/{userId}")
                .encode()
                .build()
                .expand(100) // userId 순서대로 추가하면 들어감
                .toUri();


        log.info("made uri : {}", uri.toString());
        UserRequest userRequest = new UserRequest("nbnad",123);

        Req req = new Req(new Req.Header(),userRequest);

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","dddd")
                .body(req);
        log.info("made requestEntity : {}", requestEntity);

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<Req<UserResponse>> responseEntity =
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>(){});
        log.info("result status code: {}",responseEntity.getStatusCode());
        log.info("result Header : {}",responseEntity.getHeaders());
        log.info("result : {}",responseEntity.getBody());

        return responseEntity.getBody();

    }
}
