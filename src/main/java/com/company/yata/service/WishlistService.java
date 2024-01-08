package com.company.yata.service;

import com.company.yata.dto.ResponseDto;
import com.company.yata.dto.WishlistDto;
import com.company.yata.mapper.WishlistMapper;
import com.company.yata.models.Wishlist;
import com.company.yata.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;

    public ResponseDto<WishlistDto> create(WishlistDto dto) {
        try {
            Wishlist wishlist = wishlistMapper.toEntity(dto);
            wishlist.setCreatedAt(LocalDateTime.now());
            wishlistRepository.save(wishlist);
            return ResponseDto.<WishlistDto>builder()
                    .success(true)
                    .message("Wishlist successfully created!")
                    .data(wishlistMapper.toDto(wishlist))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<WishlistDto> get(Integer id) {
        Optional<Wishlist> optional = wishlistRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<WishlistDto>builder()
                .success(true)
                .message("OK")
                .data(wishlistMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<WishlistDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<WishlistDto> update(Integer id, WishlistDto dto) {
        Optional<Wishlist> optional = wishlistRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Wishlist wishlist = wishlistMapper.updateWishlistFromDto(dto, optional.get());
            wishlist.setId(optional.get().getId());
            wishlist.setUpdatedAt(LocalDateTime.now());
            wishlistRepository.save(wishlist);
            return ResponseDto.<WishlistDto>builder()
                    .success(true)
                    .message("Wishlist successfully updated!")
                    .data(wishlistMapper.toDto(wishlist))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist while updating error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<WishlistDto> delete(Integer id) {
        Optional<Wishlist> optional = wishlistRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Wishlist wishlist = optional.get();
            wishlist.setDeletedAt(LocalDateTime.now());
            wishlistRepository.save(wishlist);
            return ResponseDto.<WishlistDto>builder()
                    .success(true)
                    .message("Wishlist successfully deleted!")
                    .data(wishlistMapper.toDto(wishlist))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<WishlistDto>builder()
                    .message("Wishlist while deleting error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }
}
