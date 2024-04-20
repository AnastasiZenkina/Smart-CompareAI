package com.medicalmarcetplace.smart_compare.service;

import com.medicalmarcetplace.smart_compare.model.Product;
import com.medicalmarcetplace.smart_compare.model.CompareResult;
import com.medicalmarcetplace.smart_compare.util.ScoreCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompareService {

    private final AiAnalysisService aiAnalysisService;

    public CompareResult compare(Product product1, Product product2) {
        int score1 = ScoreCalculator.calculate(product1);
        int score2 = ScoreCalculator.calculate(product2);

        Product recommended = score1 >= score2 ? product1 : product2;
        int scoreDifference = Math.abs(score1 - score2);

        String aiReason = aiAnalysisService.generateComparisonReason(product1, product2, score1, score2);

        return new CompareResult(recommended, aiReason, scoreDifference);
    }
}