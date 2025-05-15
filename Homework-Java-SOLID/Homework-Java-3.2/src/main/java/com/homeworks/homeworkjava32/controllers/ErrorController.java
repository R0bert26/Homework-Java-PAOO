package com.homeworks.homeworkjava32.controllers;

import com.homeworks.homeworkjava32.domain.dtos.ErrorResponseDto;
import com.homeworks.homeworkjava32.exceptions.InfiniteSolutionException;
import com.homeworks.homeworkjava32.exceptions.NoSolutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(NoSolutionException.class)
    public ResponseEntity<ErrorResponseDto> handleNoSolutionException(NoSolutionException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
    }

    @ExceptionHandler(InfiniteSolutionException.class)
    public ResponseEntity<ErrorResponseDto> handleInfiniteSolutionException(InfiniteSolutionException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
    }
}
