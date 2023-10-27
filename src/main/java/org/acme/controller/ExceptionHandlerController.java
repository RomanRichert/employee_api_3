package org.acme.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.acme.dto.ErrorResponseDTO;
import org.acme.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorResponseDTO handleEntityNotFoundException(EmployeeNotFoundException ex) {
        return buildErrorResponseDTO(ex, NOT_FOUND);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponseDTO handleValidationErrors(ConstraintViolationException e) {
        Map<String, List<String>> errors = e.getConstraintViolations().stream()
                .collect(groupingBy(c -> c.getPropertyPath().toString(),
                        mapping(ConstraintViolation::getMessageTemplate,
                                toList())));

        return ErrorResponseDTO.builder()
                .message("Input validation error")
                .status(BAD_REQUEST)
                .statusCode(BAD_REQUEST.value())
                .errors(errors)
                .build();
    }


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponseDTO(ex, BAD_REQUEST);
    }


    private ErrorResponseDTO buildErrorResponseDTO(Exception ex, HttpStatus status) {
        return ErrorResponseDTO.builder()
                .status(status)
                .message(ex.getMessage())
                .statusCode(status.value())
                .errors(ex.hashCode())
                .build();
    }
}