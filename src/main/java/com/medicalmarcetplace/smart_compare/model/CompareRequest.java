package com.medicalmarcetplace.smart_compare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompareRequest {
    private String productId1;
    private String productId2;
}