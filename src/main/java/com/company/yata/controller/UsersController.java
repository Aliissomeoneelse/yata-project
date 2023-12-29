package com.company.yata.controller;

import com.company.yata.dto.ResponseDto;
import com.company.yata.dto.UsersDto;
import com.company.yata.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseDto<UsersDto> create(@RequestBody UsersDto dto) {
        return usersService.create(dto);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<UsersDto> get(@PathVariable("id") Integer id) {
        return usersService.get(id);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<UsersDto>> getAll(@RequestParam Map<String, String> params) {
        return usersService.getAll(params);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<UsersDto> update(@PathVariable("id") Integer id, @RequestBody UsersDto dto) {
        return usersService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<UsersDto> delete(@PathVariable("id") Integer id) {
        return usersService.delete(id);
    }
}