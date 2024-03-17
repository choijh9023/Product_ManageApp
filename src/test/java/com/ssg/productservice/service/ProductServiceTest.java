package com.ssg.productservice.service;

import com.ssg.productservice.domain.ProductVO;
import com.ssg.productservice.dto.PageRequestDTO;
import com.ssg.productservice.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductServiceTest {
    @Autowired(required = false)
    private ProductService productService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testconnection()throws SQLException {
        Connection connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testregist() {
        ProductDTO productDTO = ProductDTO.builder()
                .pname("register테스트")
                .price(9999)
                .inventory(1).build();
        productService.regist(productDTO);


    }

    @Test
    public void testgetOne() {
        Long pno = 2L;
        productService.getOne(pno);
    }

    @Test
    public void testGetAll() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10).build();
        productService.getAll(pageRequestDTO);

    }

    @Test
    public void testModify() {
        ProductDTO productDTO = ProductDTO.builder()
                .pno(1L)
                .price(2)
                .pname("Modify테스트")
                .inventory(1).build();
        productService.modify(productDTO);

    }

    @Test
    public void testremove() {
        Long pno = 1L;
        productService.remove(pno);
    }
}
