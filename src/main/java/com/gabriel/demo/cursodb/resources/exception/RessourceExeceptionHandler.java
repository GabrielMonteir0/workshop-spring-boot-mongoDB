package com.gabriel.demo.cursodb.resources.exception;

import com.gabriel.demo.cursodb.service.execption.ObjectNotFoundExecption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RessourceExeceptionHandler {

    @ExceptionHandler(ObjectNotFoundExecption.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExecption e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "não encontrado, tente novamente.", e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(err);
    }
}
