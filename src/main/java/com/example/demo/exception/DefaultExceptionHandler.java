package com.example.demo.exception;

import com.example.demo.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResultJson handleCustomException(CustomException e) {
        log.error(e.getResultJson().getMsg().toString());
        return e.getResultJson();
    }
}
