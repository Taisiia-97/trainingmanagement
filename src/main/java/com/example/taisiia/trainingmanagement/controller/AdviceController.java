package com.example.taisiia.trainingmanagement.controller;

import com.example.taisiia.trainingmanagement.domain.dto.ErrorDto;
import com.example.taisiia.trainingmanagement.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(NotFoundException notFoundException) {
        log.error("Not found entity", notFoundException);


        return new ErrorDto(notFoundException.getMessage());
    }
}
