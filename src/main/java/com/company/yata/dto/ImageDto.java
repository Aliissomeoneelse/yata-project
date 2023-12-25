package com.company.yata.dto;

import com.company.yata.models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDto {
    private Integer id;
    private String name;
    private String path;
    private String ext;
    private Boolean status;
    private byte[] data;

    private Set<ProductDto> products;

    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
