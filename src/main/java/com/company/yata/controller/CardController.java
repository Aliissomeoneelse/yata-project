package com.company.yata.controller;

import com.company.yata.dto.CardDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseDto<CardDto> create(@RequestBody CardDto dto) {
        return cardService.create(dto);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<CardDto> get(@PathVariable("id") Integer id) {
        return cardService.get(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = ("/get-all"))
    public ResponseDto<Page<CardDto>> getAll(@RequestParam Map<String, String> params) {
        return cardService.getAll(params);
    }
    @CrossOrigin(origins = "*")
    @PutMapping(value = "/update/{id}")
    public ResponseDto<CardDto> update(@PathVariable("id") Integer id, @RequestBody CardDto dto) {
        return cardService.update(dto, id);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<CardDto> delete(@PathVariable("id") Integer id) {
        return cardService.delete(id);
    }
}

//#todo: http://localhost:8081/card/create
