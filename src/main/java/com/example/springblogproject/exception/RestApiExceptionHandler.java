package com.example.springblogproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MsgStatusResponseDto> IllegalArgumentExceptionMessage(IllegalArgumentException e) {
        MsgStatusResponseDto msgStatusResponseDto = new MsgStatusResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(msgStatusResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MsgStatusResponseDto> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        MsgStatusResponseDto msgStatusResponseDto = new MsgStatusResponseDto(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(msgStatusResponseDto, HttpStatus.BAD_REQUEST);
    }
}