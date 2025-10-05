package com.terminalchat.chatinterminal.model;

public class ChatMessage {
    private String from;
    private String text;
    private String room;

    public ChatMessage() {}

    public ChatMessage(String from, String text, String room) {
        this.from = from;
        this.text = text;
        this.room = room;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
