package com.stackroute.MusicService.Exceptions;

public class MusicAlreadyExistsException extends Exception{

        private String message;

    public MusicAlreadyExistsException() {}

    public MusicAlreadyExistsException(String message) {
            super(message);
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

