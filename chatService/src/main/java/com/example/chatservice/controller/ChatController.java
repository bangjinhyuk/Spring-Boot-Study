package com.example.chatservice.controller;

import com.example.chatservice.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by bangjinhyuk on 2021/09/10.
 */
@Controller
@RequiredArgsConstructor
public class ChatController {
//    private final SimpMessagingTemplate template;
//
//    @MessageMapping(value = "/chat/enter")
//    public void enter(MessageDto message){
//        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
//        template.convertAndSend("/sub/chat/room/"+message.getRoomId(),message);
//    }
//
//    @MessageMapping(value = "/chat/message")
//    public void message(MessageDto message){
//        template.convertAndSend("/sub/chat/room" + message.getRoomId(),message);
//    }
private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
