package com.medicalmarcetplace.smart_compare.util;

import com.medicalmarcetplace.smart_compare.model.Product;
import java.util.List;

public class ScoreCalculator {

    public static int calculate(Product product) {
        int score = 0;
        score -= (int)(product.getPrice() / 100);
        score += product.getRating() * 10;

        List<String> certs = product.getCertifications();
        if (certs != null) {
            if (certs.contains("FDA")) score += 30;
            if (certs.contains("CE")) score += 20;
            if (certs.contains("MOHAP")) score += 15;
            if (certs.contains("ISO")) score += 10;
        }
        if (product.isInStock()) score += 20;
        return score;
    }
}