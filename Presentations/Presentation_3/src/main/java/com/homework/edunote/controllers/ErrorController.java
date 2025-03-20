package com.homework.edunote.controllers;

import com.homework.edunote.domain.dtos.ErrorResponseDto;
import com.homework.edunote.exceptions.StudentNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleStudentNotFoundException(StudentNotFoundException e) {
        ErrorResponseDto error = ErrorResponseDto.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMissingFieldsException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(". "));

        ErrorResponseDto error = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Invalid data: " + message)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        ErrorResponseDto error = ErrorResponseDto.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
