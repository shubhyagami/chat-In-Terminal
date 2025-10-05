package com.terminalchat.chatinterminal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.terminalchat.chatinterminal.service.ChatMessageService;

import java.util.List;

@RestController
public class RoomsController {

    private final ChatMessageService service;

    public RoomsController(ChatMessageService service){ this.service = service; }

    @GetMapping("/api/rooms")
    public List<String> rooms(){
        return service.listRooms();
    }
}
