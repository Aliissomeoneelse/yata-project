package com.company.yata.service;

import com.company.yata.dto.CategoryDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.mapper.CategoryMapper;
import com.company.yata.models.Category;
import com.company.yata.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        try {
            Category category = categoryMapper.toEntity(dto);
            category.setCreatedAt(LocalDateTime.now());
            this.categoryRepository.save(category);
            return ResponseDto.<CategoryDto>builder()
                    .success(true)
                    .message("Category successfully created!")
                    .data(categoryMapper.toDto(category))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category while saving error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CategoryDto> get(Integer id) {
        Optional<Category> optional = categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<CategoryDto>builder()
                .success(true)
                .message("OK")
                .data(categoryMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<CategoryDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<CategoryDto> update(CategoryDto dto, Integer id) {
        Optional<Category> optional = categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Category category = categoryMapper.toEntity(dto);
            categoryMapper.updateCategoryFromDto(dto, optional.get());
            category.setId(optional.get().getId());
            category.setUpdatedAt(LocalDateTime.now());
            this.categoryRepository.save(category);
            return ResponseDto.<CategoryDto>builder()
                    .success(true)
                    .message("Category successfully updated!")
                    .data(categoryMapper.toDto(category))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category while updating error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CategoryDto> delete(Integer id) {
        Optional<Category> optional = categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Category category = optional.get();
            category.setDeletedAt(LocalDateTime.now());
            this.categoryRepository.save(category);
            return ResponseDto.<CategoryDto>builder()
                    .success(true)
                    .message("Category successfully updated!")
                    .data(categoryMapper.toDto(category))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CategoryDto>builder()
                    .message("Category while updating error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }
}
