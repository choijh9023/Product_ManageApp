package com.ssg.productservice.mapper;

import com.ssg.productservice.domain.ProductVO;
import com.ssg.productservice.dto.PageRequestDTO;

import java.util.List;

public interface ProductMapper {

    void insert(ProductVO productVO);

    ProductVO selectOne(Long pno);

    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

    void updateOne(ProductVO productVO);

    void deletOne(Long pno);


}
