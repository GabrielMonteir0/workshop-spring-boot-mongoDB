package com.gabriel.demo.cursodb.service.execption;

public class ObjectNotFoundExecption extends RuntimeException {
    public ObjectNotFoundExecption(String msg) {
        super(msg);
    }
}
