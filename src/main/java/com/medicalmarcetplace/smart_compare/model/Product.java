package com.medicalmarcetplace.smart_compare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private int rating;
    private List<String> certifications;
    private boolean inStock;
}