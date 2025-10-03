package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HuggingFaceService {

    private final WebClient webClient;

    @Value("${huggingface.api.token}")
    private String apiToken;

    private final String API_URL = "https://whiskerburn-chatbot.hf.space/run/predict";

    public HuggingFaceService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }
    
    public String getResponse(String userMessage) {
        Map<String, Object> payload = Map.of("message", userMessage);

        String rawResponse = webClient.post()
                .uri("https://Atreyee2004-cat-chatbot.hf.space/chat")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(rawResponse);
            return root.path("response").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "😿 WhiskerBurn is speechless. Something went wrong.";
        }
    }
}
