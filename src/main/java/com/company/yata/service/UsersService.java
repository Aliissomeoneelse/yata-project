package com.company.yata.service;

import com.company.yata.dto.ResponseDto;
import com.company.yata.dto.UsersDto;
import com.company.yata.mapper.UsersMapper;
import com.company.yata.models.Users;
import com.company.yata.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    public ResponseDto<UsersDto> create(UsersDto dto) {
        try {
            Users user = usersMapper.toEntity(dto);
            user.setCreatedAt(LocalDateTime.now());
            this.usersRepository.save(user);
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("User successful created!")
                    .data(usersMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UsersDto>builder()
                    .message("User while saving error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<UsersDto> get(Integer id) {
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<UsersDto>builder()
                .success(true)
                .message("OK")
                .data(usersMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<UsersDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<UsersDto> update(UsersDto dto, Integer id) {
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Users user =optional.get();
            usersMapper.updateUsersFromDto(dto, optional.get());
            user.setId(optional.get().getId());
            user.setUpdatedAt(LocalDateTime.now());
            usersRepository.save(user);
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("User successful updated!")
                    .data(usersMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UsersDto>builder()
                    .message("User while updating error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<UsersDto> delete(Integer id) {
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Users user = optional.get();
            user.setDeletedAt(LocalDateTime.now());
            usersRepository.save(user);
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("User successful deleted!")
                    .data(usersMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UsersDto>builder()
                    .message("User while deleting error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }
}
