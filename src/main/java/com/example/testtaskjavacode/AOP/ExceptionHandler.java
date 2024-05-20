package com.example.testtaskjavacode.AOP;


import com.example.testtaskjavacode.exception.AccountAlreadyExistsEx;
import com.example.testtaskjavacode.exception.AccountNotFoundEx;
import com.example.testtaskjavacode.exception.BadQueryEx;
import com.example.testtaskjavacode.exception.BalanceNotEnoughEx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> accountNotFoundHandling(AccountNotFoundEx e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> accountHasNotEnoughBalanceHandling(BalanceNotEnoughEx e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> BadQueryHandling(BadQueryEx e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> AccountAlreadyExistsHandling(AccountAlreadyExistsEx e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> BadQueryHandling(Exception e) {
        return new ResponseEntity<>("Something went wrong, please contact with administrator", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class})
    public ResponseEntity<String> BadRequestHandling() {
        return new ResponseEntity<>("Something bad with your query, try again", HttpStatus.BAD_REQUEST);
    }

}
