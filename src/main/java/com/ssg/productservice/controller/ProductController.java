package com.ssg.productservice.controller;

import com.ssg.productservice.dto.PageRequestDTO;
import com.ssg.productservice.dto.ProductDTO;
import com.ssg.productservice.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/register") // @RequestMapping(value = "/register", method = "post")
    public void register() {
        log.info("todo.....register");
    }

    // @PostMapping 어노테이션은 HTTP POST 요청을 처리하는 핸들러 메소드임을 나타냅니다.
    @PostMapping("/register")
    public String postRegister(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 로그에 메소드 진입을 기록합니다.
        log.info("post todo register....");

        // 로그에 todoDTO 객체의 내용을 기록합니다.
        log.info(productDTO);

        // 만약 데이터에 유효성 검사 오류가 있을 경우 실행됩니다.
        if (bindingResult.hasErrors()) {
            log.error("error");
            // 오류 메시지를 리다이렉트 속성에 추가합니다.
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            // 유효성 검사 오류가 있으므로 다시 등록 페이지로 리다이렉트합니다.
            return "redirect:/product/register";
        }

        // 로그에 todoDTO 객체의 내용을 기록합니다.
        log.info(productDTO);

        // TodoService를 통해 todoDTO를 등록합니다.
        productService.regist(productDTO);

        // 등록이 완료되면 리스트 페이지로 리다이렉트합니다.
        return "redirect:/product/list";
    }

    @GetMapping("/list") // "/list" 경로로 GET 요청이 오면 이 메서드가 실행됩니다.
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        // 페이지 요청 정보와 함께 유효성 검사를 수행하는 메서드입니다.
        // @Valid 어노테이션을 사용하여 PageRequestDTO를 유효성 검사합니다.
        // 만약 유효성 검사에서 오류가 발생하면 BindingResult를 통해 결과를 받습니다.

        if (bindingResult.hasErrors()) {
            // 유효성 검사에서 오류가 발생했는지 확인합니다.
            pageRequestDTO = PageRequestDTO.builder().build();
            // 오류가 발생하면 빈 페이지 요청 객체를 생성합니다.
        }

        model.addAttribute("responseDTO", productService.getAll(pageRequestDTO));
        // 모델에 "responseDTO" 속성과 해당 페이지 요청 정보에 대한 결과를 추가합니다.
    }


    @GetMapping({"/read", "/modify"})
    public void read(Long pno, Model model,PageRequestDTO pageRequestDTO) {
        ProductDTO productDTO = productService.getOne(pno);
        log.info(productDTO);
        model.addAttribute("dto", productDTO);
    }

    // @PostMapping 어노테이션은 HTTP POST 요청을 처리하는 핸들러 메소드임을 나타냅니다.
    @PostMapping("/modify")
    public String postList(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // 만약 데이터에 유효성 검사 오류가 있을 경우 실행됩니다.
        if (bindingResult.hasErrors()) {

            // 로그에 오류가 발생했음을 기록합니다.
            log.info("has errors....");

            // 오류 메시지를 리다이렉트 속성에 추가합니다.
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            // 리다이렉트할 때 함께 전달할 파라미터를 설정합니다.
            // 여기서는 todoDTO 객체의 tno 속성을 파라미터로 추가합니다.
            redirectAttributes.addAttribute("pno", productDTO.getPno());
        }

        // 로그에 todoDTO 객체의 내용을 기록합니다.
        log.info(productDTO);

        // TodoService를 통해 todoDTO를 수정합니다.
        productService.modify(productDTO);

        // 수정이 완료되면 리스트 페이지로 리다이렉트합니다.
        return "redirect:/product/list";
    }


    @PostMapping("/remove")
    public String remove(Long pno, RedirectAttributes redirectAttributes) {
        log.info("----------------remove");
        log.info("pno =" + pno);

        productService.remove(pno);
        return "redirect:/product/list";
    }

}