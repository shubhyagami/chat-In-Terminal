package com.terminalchat.chatinterminal.service;

import com.terminalchat.chatinterminal.entity.ChatMessageEntity;
import com.terminalchat.chatinterminal.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ChatMessageService {

    private final ChatMessageRepository repo;

    public ChatMessageService(ChatMessageRepository repo) {
        this.repo = repo;
    }

    public ChatMessageEntity save(String room, String sender, String text){
        ChatMessageEntity e = new ChatMessageEntity(room, sender, text, Instant.now());
        return repo.save(e);
    }

    public List<ChatMessageEntity> history(String room){
        return repo.findTop200ByRoomOrderByCreatedAtAsc(room);
    }

    public List<String> listRooms(){
        return repo.findDistinctRooms();
    }
}
