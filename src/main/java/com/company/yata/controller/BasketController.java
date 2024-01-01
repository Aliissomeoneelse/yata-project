package com.company.yata.controller;

import com.company.yata.dto.BasketDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketController {
    private final BasketService basketService;
    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseDto<BasketDto> create(@RequestBody BasketDto dto) {
        return basketService.create(dto);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public ResponseDto<BasketDto> get(@PathVariable("id") Integer id) {
        return basketService.get(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<BasketDto>> getAll(@RequestParam Map<String, String> params) {
        return basketService.getAll(params);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseDto<BasketDto> update(@PathVariable("id") Integer id, @RequestBody BasketDto dto) {
        return basketService.update(id, dto);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseDto<BasketDto> delete(@PathVariable("id") Integer id) {
        return basketService.delete(id);
    }
}
