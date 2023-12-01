package com.tenco.indiepicter._core.handler;

import com.tenco.indiepicter._core.handler.exception.CustomPageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyPageExceptionHandler {

    @ExceptionHandler(CustomPageException.class)
    public ModelAndView handleRuntimeException(CustomPageException e) {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("statusCode", HttpStatus.NOT_FOUND.value());
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }
}
