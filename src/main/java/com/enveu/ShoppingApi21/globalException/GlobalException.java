package com.enveu.ShoppingApi21.globalException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException extends Throwable {


    public String productNotFound()
    {
        return "No product found on such id";
    }
}
