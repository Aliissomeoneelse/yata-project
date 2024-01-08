package com.company.yata.service;

import com.company.yata.dto.CardDto;
import com.company.yata.dto.ResponseDto;
import com.company.yata.mapper.CardMapper;
import com.company.yata.models.Card;
import com.company.yata.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    public ResponseDto<CardDto> create(CardDto dto) {
        try {
            Card card = cardMapper.toEntity(dto);
            card.setCreatedAt(LocalDateTime.now());
            this.cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("Card successfully created!")
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message("Card while saving error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CardDto> get(Integer id) {
        Optional<Card> optional = cardRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<CardDto>builder()
                .success(true)
                .message("OK")
                .data(cardMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Page<CardDto>> getAll(Map<String, String> params) {
        return null;
    }

    public ResponseDto<CardDto> update(CardDto dto, Integer id) {
        Optional<Card> optional = cardRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Card card = cardMapper.toEntity(dto);
            cardMapper.updateCardFromDto(dto, optional.get());
            card.setId(optional.get().getId());
            card.setUpdatedAt(LocalDateTime.now());
            this.cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("Card successfully updated!")
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message("Card while updating error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CardDto> delete(Integer id) {
        Optional<Card> optional = cardRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            Card card = optional.get();
            card.setDeletedAt(LocalDateTime.now());
            this.cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("Card successfully deleted!")
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message("Card while deleting error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

}
