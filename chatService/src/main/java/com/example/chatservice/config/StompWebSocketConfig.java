package com.example.chatservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by bangjinhyuk on 2021/09/10.
 */
@EnableWebSocketMessageBroker //웹 소켓 서버 사용 설정
@Configuration
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) { // 웹소켓에 접속하는 endpoint 등록
//        registry.addEndpoint("/stomp")
//                .withSockJS(); //웹소켓을 지원 하지 않을 경우 fallback 옵션 활성화
//    }
//
//    // 한 클라이언트에서 다른 클라이언트로 메세지를 라우팅할때 사용하는 브로커 구성
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/pub"); //클라이언트에서 send 요청 처리
//        registry.enableSimpleBroker("sub"); //해당 경로를 구독하는 클라이언트에세 메세지 전달 작업 수행
//    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
