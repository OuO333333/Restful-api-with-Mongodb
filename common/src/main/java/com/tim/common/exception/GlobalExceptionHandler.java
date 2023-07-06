package com.tim.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> unknownException(Exception e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("general message", e.getMessage());
        return map;
    }

    @ExceptionHandler(ItemNotExistsException.class)
    @ResponseBody
    public Map<String, Object> specificException(ItemNotExistsException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("spcific message", e.getMessage());
        return map;
    }
}
