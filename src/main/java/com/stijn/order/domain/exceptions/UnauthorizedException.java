package com.stijn.order.domain.exceptions;

public class UnauthorizedException extends IllegalArgumentException{
    public UnauthorizedException() {
        super("User has no authorization for this request.");
    }
}
