package com.medicalmarcetplace.smart_compare.service;

import com.medicalmarcetplace.smart_compare.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final Map<String, Product> productDatabase = new HashMap<>();

    {
        productDatabase.put("p1", new Product("p1", "PRP TUBE - ACD", "Dermatology", 18.0,
                4, List.of("CE"), true));
        productDatabase.put("p2", new Product("p2", "Orliman Ankle Support", "Orthopedic", 291.56,
                5, List.of("FDA", "CE", "MOHAP"), true));
        productDatabase.put("p3", new Product("p3", "Kendall SCD 700 Series", "Hospital Furniture", 12117.0,
                3, List.of("ISO"), false));
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productDatabase.get(id));
    }
}