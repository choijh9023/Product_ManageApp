package com.ssg.productservice.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
@Builder
public class ProductDTO {
    private Long pno;
    @NotEmpty
    private String pname;

    private int price;

    private int inventory;

}
