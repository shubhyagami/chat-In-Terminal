package com.terminalchat.chatinterminal.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "chat_messages")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String room;
    private String sender;

    @Column(length = 2000)
    private String text;

    private Instant createdAt;

    public ChatMessageEntity() {}

    public ChatMessageEntity(String room, String sender, String text, Instant createdAt) {
        this.room = room;
        this.sender = sender;
        this.text = text;
        this.createdAt = createdAt;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
