package com.company.yata.controller;

import com.company.yata.dto.ResponseDto;
import com.company.yata.dto.WishlistDto;
import com.company.yata.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("wishlist")
public class WishlistController {
    private final WishlistService wishlistService;
    @PostMapping("/create")
    public ResponseDto<WishlistDto> create(@RequestBody WishlistDto dto) {
        return wishlistService.create(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<WishlistDto> get(@PathVariable("id") Integer id) {
        return wishlistService.get(id);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<WishlistDto>> getAll(@RequestParam Map<String, String> params) {
        return wishlistService.getAll(params);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<WishlistDto> update(@PathVariable("id") Integer id, @RequestBody WishlistDto dto) {
        return wishlistService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<WishlistDto> delete(@PathVariable("id") Integer id) {
        return wishlistService.delete(id);
    }
}
