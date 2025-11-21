package com.joas.todo.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingStatusException extends RuntimeException{

    public MissingStatusException(String message){
        super(message);
    }
}