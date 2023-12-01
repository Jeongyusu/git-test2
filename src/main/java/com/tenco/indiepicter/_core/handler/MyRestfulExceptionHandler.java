package com.tenco.indiepicter._core.handler;

import com.tenco.indiepicter._core.handler.exception.CustomRestfulException;
import com.tenco.indiepicter._core.handler.exception.UnAuthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyRestfulExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        System.out.println("-------------------------------");
        System.out.println("e.getClass().getName()");
        System.out.println("e.getMessage()");
        System.out.println("-------------------------------");
    }

    //사용자 정의 예외 클래스 활용
    @ExceptionHandler(CustomRestfulException.class)
    public String basicException(CustomRestfulException e) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('"+ e.getMessage() +"');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
    @ExceptionHandler(UnAuthorizedException.class)
    public String unAuthorizedException(UnAuthorizedException e) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('"+ e.getMessage() +"');");
        sb.append("location.href='/user/sign-in';");
        sb.append("</script>");
        return sb.toString();
    }
}
