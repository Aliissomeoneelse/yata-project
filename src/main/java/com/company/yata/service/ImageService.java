package com.company.yata.service;

import com.company.yata.dto.ImageDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.mapper.ImageMapper;
import com.company.yata.models.Image;
import com.company.yata.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    public ResponseDto<ImageDto> upload(MultipartFile image) {
        try {
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.imageMapper.toDto(
                            this.imageRepository.save(
                                    Image.builder()
                                            .name(Objects.requireNonNull(image.getOriginalFilename()).split("\\.")[0])
                                            .ext(Objects.requireNonNull(image.getOriginalFilename()).split("\\.")[1])
                                            .createdAt(LocalDateTime.now())
                                            .path(saveFile(image))
                                            .status(true)
                                            .build())))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("File while saving error message :: " + e.getMessage())
                    .build();
        }
    }

    private String saveFile(MultipartFile file) throws IOException {
        String folders = String.format("%s/%s", "upload", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        java.io.File fileModel = new java.io.File(folders);
        if (!fileModel.exists()) {
            fileModel.mkdirs();
        }
        String fileName = String.format("%s/%s", folders, UUID.randomUUID());
        Files.copy(file.getInputStream(), Path.of(fileName));
        return fileName;
    }

    public ResponseDto<ImageDto> download(Integer id) {
        return this.imageRepository.findByIdAndDeletedAtIsNull(id)
                .map(fileModel -> {
                    try {
                        ImageDto dto = this.imageMapper.toDto(fileModel);
                        dto.setData(Files.readAllBytes(Path.of(fileModel.getPath())));
                        return ResponseDto.<ImageDto>builder()
                                .success(true)
                                .message("OK")
                                .data(dto)
                                .build();
                    } catch (Exception e) {
                        return ResponseDto.<ImageDto>builder()
                                .code(-3)
                                .message("File while getting error message :: " + e.getMessage())
                                .build();
                    }
                })
                .orElse(ResponseDto.<ImageDto>builder()
                        .code(-1)
                        .message(String.format("File with file id :: %d is not found!", id))
                        .build());
    }

    public ResponseDto<Set<ImageDto>> get(Integer id) {
        Set<Image> files = imageRepository.findAllByIdAndDeletedAtIsNull(id);
        if (files.isEmpty()) {
            return ResponseDto.<Set<ImageDto>>builder()
                    .message("Files are not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<Set<ImageDto>>builder()
                .success(true)
                .message("OK")
                .data(imageMapper.toSetDto(files))
                .build();
    }

    public ResponseDto<ImageDto> update(ImageDto dto, Integer id) {
        Optional<Image> optional = imageRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message("File is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Image image = optional.get();
            imageMapper.updateImagesFromDto(dto, optional.get());
            image.setId(optional.get().getId());
            image.setUpdatedAt(LocalDateTime.now());
            imageRepository.save(image);
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("File successful updated!")
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .message("File while updating error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<ImageDto> delete(Integer id) {
        try {
            return this.imageRepository.findByIdAndDeletedAtIsNull(id)
                    .map(fileModel -> {
                        java.io.File file = new java.io.File(fileModel.getPath());
                        if (file.exists()) {
                            file.delete();
                        }
                        fileModel.setDeletedAt(LocalDateTime.now());
                        this.imageRepository.save(fileModel);
                        return ResponseDto.<ImageDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.imageMapper.toDto(fileModel))
                                .build();
                    })
                    .orElse(ResponseDto.<ImageDto>builder()
                            .code(-1)
                            .message(String.format("File with file id :: %d is not found!", id))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("File while deleting error message :: " + e.getMessage())
                    .build();
        }
    }
}
