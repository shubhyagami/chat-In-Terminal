package com.terminalchat.chatinterminal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/room/{room}")
    public String room(@PathVariable String room, Model model) {
        model.addAttribute("room", room);
        return "room";
    }
}
