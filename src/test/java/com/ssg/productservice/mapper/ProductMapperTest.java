package com.ssg.productservice.mapper;

import com.ssg.productservice.domain.ProductVO;
import com.ssg.productservice.dto.PageRequestDTO;
import com.ssg.productservice.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class ProductMapperTest {

    @Autowired(required = false)
    private ProductMapper productMapper;


    @Test
    public void testinsert() {
        ProductVO productVO = ProductVO.builder()
                .pname("테스트상품")
                .price(1000)
                .inventory(30).build();
        productMapper.insert(productVO);

    }
    @Test
    public void testSelectOne() {
        Long pno = 2L;
        log.info(productMapper.selectOne(pno));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10).build();
        List<ProductVO> productVOList = productMapper.selectList(pageRequestDTO);
        productVOList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testUpdateOne() {
        Long pno = 2L;
        ProductVO productVO = ProductVO.builder()
                .pno(pno)
                .pname("업데이트테스트")
                .price(1)
                .inventory(1).build();
        productMapper.updateOne(productVO);

    }

    @Test
    public void testDeleteOne() {
        Long pno = 2L;
        productMapper.deletOne(pno);
    }
}