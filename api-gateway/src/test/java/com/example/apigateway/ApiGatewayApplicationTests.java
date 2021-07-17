package com.example.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
//import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
//@SpringBootTest
class ApiGatewayApplicationTests {

    @Test
    void contextLoads() {
//        // 1. API 연동을 위한 기반 데이터를 준비한다.
//        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";
//        String serviceKey = "aeTzzOFSwrqvBDKTkhKD0rGzwc%2BSDaHdsjgjwYMtBGtVY%2FEPXx5EHpabdqgZg5Kes2b%2FCBvZlQqx1wZNqp14Xg%3D%3D";
//        String Q0 = "서울특별시";
//        String Q1 = "강남구";
//        String ORD = "ADDR";
//        String pageNo = "1";
//        String numOfRows = "100";
//        // 2. 데이터를 XML로 변환할 기능을 추가한다.
//        XStreamMarshaller marshaller = new XStreamMarshaller();
//        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
//        converters.add(new FormHttpMessageConverter());
//        converters.add(new StringHttpMessageConverter());
//        converters.add(new MarshallingHttpMessageConverter(marshaller));
//
//        // 3. REST API로 전달하기 위한 RestTemplate을 준비한다.
//        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
//        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
//        restTemplate.setMessageConverters(converters);
//
//        // 4. API 전송 시 필요한 Header 값을 설정한다.
//        HttpHeaders headers = new HttpHeaders();
//        Charset utf8 = Charset.forName("UTF-8");
//        MediaType mediaType = new MediaType("application", "xml", utf8);
//        headers.setContentType(mediaType);
//
//
//        // 5. 준비한 데이터의 인코딩을 조정한다.
//        String Q0enc = UriUtils.encode(Q0, "UTF-8");
//        String Q1enc = UriUtils.encode(Q1, "UTF-8");
//        System.out.println("[URI] Q0enc: " + Q0enc);
//        System.out.println("[URI] Q1enc: " + Q1enc);
//
//        // 6. 준비된 데이터를 기반으로 URI를 생성한다.
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//                .queryParam("serviceKey", serviceKey)
//                .queryParam("Q0", Q0enc)
//                .queryParam("Q1", Q1enc)
//                .queryParam("ORD", ORD)
//                .queryParam("pageNo", pageNo)
//                .queryParam("numOfRows", numOfRows);
//        String uriString = builder.build(false).toString();
//        System.out.println("[URI] uriString: " + uriString);
//
//        // 7. Request 요청 시 전송할 Entity를 구성한다.
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        // 8. REST API를 전송한다.
//        HttpEntity<String> response = restTemplate.exchange(
//                uriString,
//                HttpMethod.GET,
//                entity,
//                String.class);
//
//        // 9. 응답받은 Response를 출력한다.
//        System.out.println("[Respose] Body: " + response.toString());
    }

}
