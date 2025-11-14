package com.joas.todo.Exceptions;



public class StatusNotFoundException extends RuntimeException{

    public StatusNotFoundException(String message){
        super(message);
    }
}
