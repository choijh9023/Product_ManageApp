package com.ssg.productservice.domain;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class ProductVO {
    private Long pno;
    private String pname;
    private int price;
    private int inventory;

}