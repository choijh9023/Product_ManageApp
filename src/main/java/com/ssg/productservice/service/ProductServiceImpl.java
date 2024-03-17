package com.ssg.productservice.service;

import com.ssg.productservice.domain.ProductVO;
import com.ssg.productservice.dto.PageRequestDTO;
import com.ssg.productservice.dto.PageResponseDTO;
import com.ssg.productservice.dto.ProductDTO;
import com.ssg.productservice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;
    @Override
    public void regist(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productMapper.insert(productVO);

    }

    @Override
    public ProductDTO getOne(Long pno) {
        ProductVO productVO = productMapper.selectOne(pno);
        ProductDTO productDTO = modelMapper.map(productVO, ProductDTO.class);

        return productDTO;
    }

    @Override
    public PageResponseDTO<ProductDTO> getAll(PageRequestDTO pageRequestDTO) {
        List<ProductVO> vos = productMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtos = vos.stream()
                .map(vo -> modelMapper.map(vo, ProductDTO.class))
                .collect(Collectors.toList());
        int total = productMapper.getCount(pageRequestDTO);

        PageResponseDTO<ProductDTO> pageResponseDTO = PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtos)
                .total(total)
                .pageRequestDTO(pageRequestDTO).build();

        return pageResponseDTO;
    }

    @Override
    public void modify(ProductDTO productDTO) {

        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productMapper.updateOne(productVO);

    }

    @Override
    public void remove(Long pno) {
        productMapper.deletOne(pno);
    }
}
