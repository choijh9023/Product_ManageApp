package com.ssg.productservice.service;

import com.ssg.productservice.dto.PageRequestDTO;
import com.ssg.productservice.dto.PageResponseDTO;
import com.ssg.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void regist(ProductDTO productDTO);

    ProductDTO getOne(Long pno);

    PageResponseDTO<ProductDTO> getAll(PageRequestDTO pageRequestDTO);

    void modify(ProductDTO productDTO);

    void remove(Long pno);
}
