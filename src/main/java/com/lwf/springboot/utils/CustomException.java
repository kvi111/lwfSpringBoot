package com.lwf.springboot.utils;

/**
 * Created by lwf on 2017/3/10.
 */
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}