package com.learn.own.reactiveprogram.fluxandmonoplayground;

public class CustomException extends Throwable {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(Throwable e) {
        this.message = e.getMessage();
    }
}
