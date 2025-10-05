package com.terminalchat.chatinterminal.controller;

import com.terminalchat.chatinterminal.entity.ChatMessageEntity;
import com.terminalchat.chatinterminal.service.ChatMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {

    private final ChatMessageService service;

    public HistoryController(ChatMessageService service){ this.service = service; }

    @GetMapping("/api/history/{room}")
    public List<ChatMessageEntity> history(@PathVariable String room){
        return service.history(room);
    }
}
