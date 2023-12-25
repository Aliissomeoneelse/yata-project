package com.company.yata.service;

import com.company.yata.dto.ProductDto;
import com.company.yata.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    public ResponseDto<ProductDto> create(ProductDto dto) {
        return null;
    }

    public ResponseDto<ProductDto> get(Integer id) {
        return null;
    }

    public ResponseDto<Page<ProductDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<ProductDto> update(ProductDto dto, Integer id) {
        return null;
    }

    public ResponseDto<ProductDto> delete(Integer id) {
        return null;
    }
}
