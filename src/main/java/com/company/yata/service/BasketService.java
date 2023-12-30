package com.company.yata.service;

import com.company.yata.dto.BasketDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.mapper.BasketMapper;
import com.company.yata.models.Basket;
import com.company.yata.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;

    public ResponseDto<BasketDto> create(BasketDto dto) {
        try {
            Basket basket = basketMapper.toEntity(dto);
            basket.setCreatedAt(LocalDateTime.now());
            basketRepository.save(basket);
            return ResponseDto.<BasketDto>builder()
                    .success(true)
                    .message("Basket successfully created!")
                    .data(basketMapper.toDto(basket))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<BasketDto> get(Integer id) {
        Optional<Basket> optional = basketRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<BasketDto>builder()
                .success(true)
                .message("OK")
                .data(basketMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<BasketDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<BasketDto> update(Integer id, BasketDto dto) {
        Optional<Basket> optional = basketRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Basket basket = basketMapper.updateBasketFromDto(dto, optional.get());
            basket.setId(optional.get().getId());
            basket.setUpdatedAt(LocalDateTime.now());
            basketRepository.save(basket);
            return ResponseDto.<BasketDto>builder()
                    .success(true)
                    .message("Basket successfully updated!")
                    .data(basketMapper.toDto(basket))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket while updating error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }


    public ResponseDto<BasketDto> delete(Integer id) {
        Optional<Basket> optional = basketRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Basket basket = optional.get();
            basket.setId(optional.get().getId());
            basket.setDeletedAt(LocalDateTime.now());
            basketRepository.save(basket);
            return ResponseDto.<BasketDto>builder()
                    .success(true)
                    .message("Basket successfully deleted!")
                    .data(basketMapper.toDto(basket))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BasketDto>builder()
                    .message("Basket while deleting error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

}