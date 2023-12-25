package com.company.yata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer amount;

    private Integer categoryId;

    private Integer imageId;

    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
