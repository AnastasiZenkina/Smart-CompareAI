package com.medicalmarcetplace.smart_compare.controller;

import com.medicalmarcetplace.smart_compare.model.CompareRequest;
import com.medicalmarcetplace.smart_compare.model.Product;
import com.medicalmarcetplace.smart_compare.model.CompareResult;
import com.medicalmarcetplace.smart_compare.service.CompareService;
import com.medicalmarcetplace.smart_compare.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompareControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private CompareService compareService;

    @InjectMocks
    private CompareController compareController;

    @Test
    void compare_shouldReturnBadRequest_whenProductNotFound() {
        CompareRequest request = new CompareRequest("invalid1", "invalid2");
        when(productService.findById("invalid1")).thenReturn(Optional.empty());

        ResponseEntity<?> response = compareController.compare(request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void compare_shouldReturnOk_whenProductsFound() {
        Product p1 = new Product();
        p1.setId("p1");
        Product p2 = new Product();
        p2.setId("p2");
        CompareRequest request = new CompareRequest("p1", "p2");
        CompareResult mockResult = new CompareResult(p1, "Good", 10);

        when(productService.findById("p1")).thenReturn(Optional.of(p1));
        when(productService.findById("p2")).thenReturn(Optional.of(p2));
        when(compareService.compare(p1, p2)).thenReturn(mockResult);

        ResponseEntity<?> response = compareController.compare(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResult, response.getBody());
    }
}