package com.company.yata.controller;

import com.company.yata.dto.ImageDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseDto<ImageDto> upload(@RequestBody MultipartFile image) {
        return imageService.upload(image);
    }

    @GetMapping(value = ("/download/{id}"))
    public ResponseDto<ImageDto> download(@PathVariable("id") Integer id) {
        return imageService.download(id);
    }

    @GetMapping(value = ("/get-image-by-user/{id}"))
    public ResponseDto<Set<ImageDto>> get(@PathVariable("id") Integer id) {
        return imageService.get(id);
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
