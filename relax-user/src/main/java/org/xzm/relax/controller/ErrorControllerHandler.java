package org.xzm.relax.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xzm.relax.exception.ExceptionType;
import org.xzm.relax.exception.ServiceException;
import org.xzm.relax.model.dto.Result;

@RestControllerAdvice
public class ErrorControllerHandler {

    @ExceptionHandler(ServiceException.class)
    public Result<String> serviceException(ServiceException e){
        return Result.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> defaultException(Exception e){
        return Result.error(ExceptionType.UNKNOW_ERROR.getCode(),e.getMessage());
    }

}
