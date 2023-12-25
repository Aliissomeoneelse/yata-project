package com.company.yata.service;

import com.company.yata.dto.ResponseDto;
import com.company.yata.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsersService {

    public ResponseDto<UsersDto> create(UsersDto dto) {
        return null;
    }

    public ResponseDto<UsersDto> get(Integer id) {
        return null;
    }

    public ResponseDto<Page<UsersDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<UsersDto> update(UsersDto dto, Integer id) {
        return null;
    }

    public ResponseDto<UsersDto> delete(Integer id) {
        return null;
    }
}
