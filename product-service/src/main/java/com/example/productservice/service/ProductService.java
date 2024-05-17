package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse saveProduct(ProductRequest productRequest) {
        ProductResponse response = productMapper.mapToResponse(productRepository.save(productMapper.mapFromRequest(productRequest)));
        log.info("Product {} is saved", productRequest.getName());
        return response;
    }
}
