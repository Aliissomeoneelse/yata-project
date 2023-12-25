package com.company.yata.service;

import com.company.yata.dto.CardDto;
import com.company.yata.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CardService {

    public ResponseDto<CardDto> create(CardDto dto) {
        return null;
    }

    public ResponseDto<CardDto> get(Integer id) {
        return null;
    }

    public ResponseDto<Page<CardDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<CardDto> update(CardDto dto, Integer id) {
        return null;
    }

    public ResponseDto<CardDto> delete(Integer id) {
        return null;
    }

}
