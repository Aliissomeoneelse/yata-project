package com.company.yata.controller;

import com.company.yata.dto.ProductDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseDto<ProductDto> create(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ProductDto> get(@PathVariable("id") Integer id) {
        return productService.get(id);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<ProductDto>> getAll(@RequestParam Map<String, String> params) {
        return productService.getAll(params);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<ProductDto> update(@PathVariable("id") Integer id, @RequestBody ProductDto dto) {
        return productService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ProductDto> delete(@PathVariable("id") Integer id) {
        return productService.delete(id);
    }
}
