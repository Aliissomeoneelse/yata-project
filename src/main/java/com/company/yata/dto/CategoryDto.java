package com.company.yata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Integer id;
    private String name;

    private Set<ProductDto> products;

    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}