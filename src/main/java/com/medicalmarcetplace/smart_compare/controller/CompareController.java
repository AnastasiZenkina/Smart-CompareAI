package com.medicalmarcetplace.smart_compare.controller;

import com.medicalmarcetplace.smart_compare.model.CompareRequest;
import com.medicalmarcetplace.smart_compare.model.CompareResult;
import com.medicalmarcetplace.smart_compare.service.CompareService;
import com.medicalmarcetplace.smart_compare.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/compare")
@RequiredArgsConstructor
public class CompareController {

    private final ProductService productService;
    private final CompareService compareService;

    @PostMapping
    public ResponseEntity<?> compare(@RequestBody CompareRequest request) {
        var opt1 = productService.findById(request.getProductId1());
        var opt2 = productService.findById(request.getProductId2());

        if (opt1.isEmpty() || opt2.isEmpty()) {
            return ResponseEntity.badRequest().body("One or both product IDs not found");
        }

        CompareResult result = compareService.compare(opt1.get(), opt2.get());
        return ResponseEntity.ok(result);
    }
}