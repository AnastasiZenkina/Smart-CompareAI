package com.medicalmarcetplace.smart_compare.service;

import com.medicalmarcetplace.smart_compare.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiAnalysisService {

    private final ChatClient.Builder chatClientBuilder;

    public String generateComparisonReason(Product product1, Product product2, int score1, int score2) {
        ChatClient chatClient = chatClientBuilder.build();
        String prompt = buildPrompt(product1, product2, score1, score2);
        log.debug("Sending prompt to OpenAI: {}", prompt);

        try {
            return chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();
        } catch (Exception e) {
            log.error("OpenAI API call failed", e);
            return "AI analysis temporarily unavailable. Please try again later.";
        }
    }

    private String buildPrompt(Product p1, Product p2, int score1, int score2) {
        return String.format("""
                You are an AI procurement assistant for MedIX, a medical equipment marketplace.
                Compare these two products and recommend the better one for a hospital buyer.
                Be concise (2-3 sentences), professional, and base your decision on all provided data.
                
                %s
                %s
                
                Internal scores (only for reference): Product1 = %d, Product2 = %d.
                """,
                formatProduct(p1), formatProduct(p2), score1, score2);
    }

    private String formatProduct(Product p) {
        return String.format("Product: %s | Price: %.2f AED | Rating: %d/5 | Certifications: %s | In Stock: %b",
                p.getName(), p.getPrice(), p.getRating(),
                (p.getCertifications() != null ? String.join(", ", p.getCertifications()) : "None"),
                p.isInStock());
    }
}