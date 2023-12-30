package com.company.yata.service;

import com.company.yata.dto.ProductDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.mapper.ProductMapper;
import com.company.yata.models.Product;
import com.company.yata.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ResponseDto<ProductDto> create(ProductDto dto) {
        try {
            Product product = productMapper.toEntity(dto);
            product.setCreatedAt(LocalDateTime.now());
            this.productRepository.save(product);
            return ResponseDto.<ProductDto>builder()
                    .success(true)
                    .message("Product successfully created!")
                    .data(productMapper.toDto(product))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product while saving error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ProductDto> get(Integer id) {
        Optional<Product> optional = productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<ProductDto>builder()
                .success(true)
                .message("OK")
                .data(productMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<ProductDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<ProductDto> update(ProductDto dto, Integer id) {
        Optional<Product> optional = productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Product product = productMapper.toEntity(dto);
            productMapper.updateProductFromDto(dto, optional.get());
            product.setId(optional.get().getId());
            product.setUpdatedAt(LocalDateTime.now());
            this.productRepository.save(product);
            return ResponseDto.<ProductDto>builder()
                    .success(true)
                    .message("Product successfully updated!")
                    .data(productMapper.toDto(product))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product while updating error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ProductDto> delete(Integer id) {
        Optional<Product> optional = productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Product product = optional.get();
            product.setDeletedAt(LocalDateTime.now());
            this.productRepository.save(product);
            return ResponseDto.<ProductDto>builder()
                    .success(true)
                    .message("Product successfully deleted!")
                    .data(productMapper.toDto(product))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ProductDto>builder()
                    .message("Product while deleting error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }
}
