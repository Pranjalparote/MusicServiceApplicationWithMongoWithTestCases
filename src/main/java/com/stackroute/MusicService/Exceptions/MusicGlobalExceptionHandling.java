package com.stackroute.MusicService.Exceptions;

import com.stackroute.MusicService.response.ResponseForError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MusicGlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MusicAlreadyExistsException.class})
    public ResponseEntity<ResponseForError> globalMusicAlreadyExistsException(MusicAlreadyExistsException ex)throws Exception {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessageInformation(ex.getMessage());
        return new ResponseEntity<>(responseForError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MusicNotFoundException.class})
    public ResponseEntity<ResponseForError> globalMusicNotFoundException(MusicNotFoundException ex) throws Exception {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessageInformation(ex.getMessage());
        return new ResponseEntity<>(responseForError, HttpStatus.BAD_REQUEST);
    }


}
