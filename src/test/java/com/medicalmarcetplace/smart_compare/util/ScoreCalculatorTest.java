package com.medicalmarcetplace.smart_compare.util;

import com.medicalmarcetplace.smart_compare.model.Product;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    @Test
    void calculate_shouldReturnHigherScoreForBetterProduct() {
        Product p1 = new Product("p1", "A", "Cat", 100.0, 5, List.of("FDA", "CE"), true);
        Product p2 = new Product("p2", "B", "Cat", 200.0, 3, List.of("CE"), false);

        int score1 = ScoreCalculator.calculate(p1);
        int score2 = ScoreCalculator.calculate(p2);

        assertTrue(score1 > score2);
    }
}