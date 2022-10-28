package com.stijn.order.domain.exceptions;

public class WrongPasswordException extends IllegalArgumentException{
    public WrongPasswordException() {
        super("Wrong credentials");
    }
}
