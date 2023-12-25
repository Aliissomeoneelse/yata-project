package com.company.yata.controller;

import com.company.yata.dto.CategoryDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseDto<CategoryDto> create(@RequestBody CategoryDto dto) {
        return categoryService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<CategoryDto> get(@PathVariable("id") Integer id) {
        return categoryService.get(id);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<CategoryDto>> getAll(@RequestParam Map<String, String> params) {
        return categoryService.getAll(params);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<CategoryDto> update(@PathVariable("id") Integer id, @RequestBody CategoryDto dto) {
        return categoryService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<CategoryDto> delete(@PathVariable("id") Integer id) {
        return categoryService.delete(id);
    }
}
