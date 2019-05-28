package com.stackroute.MusicService.exceptions;

public class MusicNotFoundException extends Exception {
    private String message;

    public MusicNotFoundException() {
    }

    public MusicNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
