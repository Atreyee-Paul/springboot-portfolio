package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@RestController
public class DialogController {

    private Map<String, Object> dialogues;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        dialogues = mapper.readValue(
            new ClassPathResource("static/data/dialogues.json").getInputStream(),
            new TypeReference<Map<String, Object>>() {}
        );
    }


    @GetMapping("/api/dialogues")
    public Map<String, Object> getDialogues() {
        return dialogues;
    }
}