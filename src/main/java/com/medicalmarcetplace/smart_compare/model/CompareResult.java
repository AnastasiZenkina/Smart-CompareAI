package com.medicalmarcetplace.smart_compare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompareResult {
    private Product recommendedProduct;
    private String reason;
    private int scoreDifference;
}