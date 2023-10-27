package org.acme.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    EMPLOYEE_NOT_FOUND("Employee not found. id = ");

    private final String message;
}