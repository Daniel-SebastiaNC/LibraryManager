package br.com.dev.danielsebastian.librarymanager.config;

import br.com.dev.danielsebastian.librarymanager.exception.DataNotFoundException;
import br.com.dev.danielsebastian.librarymanager.exception.UsernameOrPasswordInvaldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationContrllerAdvice {

    @ExceptionHandler(UsernameOrPasswordInvaldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequestException(UsernameOrPasswordInvaldException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleDataNotFoundException(DataNotFoundException ex){
        return ex.getMessage();
    }

}
