package com.terminalchat.chatinterminal.controller;

import com.terminalchat.chatinterminal.model.ChatMessage;
import com.terminalchat.chatinterminal.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService messageService;

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatMessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        if (chatMessage == null) return;
        String room = chatMessage.getRoom();
        String from = chatMessage.getFrom();
        String text = chatMessage.getText();
        if (room == null) return; // ignore
        room = room.trim();
        // defensive checks: ignore template artifacts or empty rooms
        if (room.isEmpty() || room.contains("[[") || room.contains("${")) {
            return;
        }
        if (from == null) from = "";
        if (text == null) text = "";

        // persist with normalized room
        messageService.save(room, from, text);

        // broadcast using normalized room
        String destination = "/topic/room." + room;
        messagingTemplate.convertAndSend(destination, new ChatMessage(from, text, room));
    }
}
