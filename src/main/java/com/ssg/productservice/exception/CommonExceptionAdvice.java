package com.ssg.productservice.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exception(Exception exception) {
        log.error("====");
        log.error(exception.getMessage());
        return "GET ERROR MESSAGE";
    }
}

