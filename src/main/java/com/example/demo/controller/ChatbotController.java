package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HuggingFaceService;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private HuggingFaceService huggingFaceService;

    @GetMapping
    public Map<String, String> getReply(@RequestParam String message) {
        String reply = huggingFaceService.getResponse(message);
        return Map.of("reply", reply);
    }
}
