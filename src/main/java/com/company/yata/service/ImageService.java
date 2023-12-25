package com.company.yata.service;

import com.company.yata.dto.ImageDto;
import com.company.yata.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageService {
    public ResponseDto<ImageDto> create(ImageDto dto) {
        return null;
    }

    public ResponseDto<ImageDto> get(Integer id) {
        return null;
    }

    public ResponseDto<Page<ImageDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<ImageDto> update(ImageDto dto, Integer id) {
        return null;
    }

    public ResponseDto<ImageDto> delete(Integer id) {
        return null;
    }
}
