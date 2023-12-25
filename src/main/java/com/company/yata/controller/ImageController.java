package com.company.yata.controller;

import com.company.yata.dto.ImageDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseDto<ImageDto> create(@RequestBody ImageDto dto) {
        return imageService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ImageDto> get(@PathVariable("id") Integer id) {
        return imageService.get(id);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<ImageDto>> getAll(@RequestParam Map<String, String> params) {
        return imageService.getAll(params);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<ImageDto> update(@PathVariable("id") Integer id, @RequestBody ImageDto dto) {
        return imageService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ImageDto> delete(@PathVariable("id") Integer id) {
        return imageService.delete(id);
    }

}
