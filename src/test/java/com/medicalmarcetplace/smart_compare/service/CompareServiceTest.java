package com.medicalmarcetplace.smart_compare.service;

import com.medicalmarcetplace.smart_compare.model.Product;
import com.medicalmarcetplace.smart_compare.model.CompareResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompareServiceTest {

    @Mock
    private AiAnalysisService aiAnalysisService;

    @InjectMocks
    private CompareService compareService;

    @Test
    void compare_shouldReturnRecommendedProduct() {
        Product p1 = new Product("1", "Product A", "Cat", 100.0, 5, List.of("FDA"), true);
        Product p2 = new Product("2", "Product B", "Cat", 200.0, 3, List.of("CE"), false);
        when(aiAnalysisService.generateComparisonReason(any(), any(), anyInt(), anyInt()))
                .thenReturn("AI reason");

        CompareResult result = compareService.compare(p1, p2);

        assertEquals(p1, result.getRecommendedProduct());
        assertNotNull(result.getReason());
    }
}