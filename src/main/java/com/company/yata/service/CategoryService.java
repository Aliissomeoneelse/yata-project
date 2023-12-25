package com.company.yata.service;

import com.company.yata.dto.CategoryDto;
import com.company.yata.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {


    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        return null;
    }

    public ResponseDto<CategoryDto> get(Integer id) {
        return null;
    }

    public ResponseDto<Page<CategoryDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<CategoryDto> update(CategoryDto dto, Integer id) {
        return null;
    }

    public ResponseDto<CategoryDto> delete(Integer id) {
        return null;
    }
}
