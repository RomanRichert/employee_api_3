package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class EmployeeCreatingDTO {

    @NotBlank(message = "First name should not be blank")
    String firstName;

    @NotBlank(message = "Last name should not be blank")
    String lastName;

    Double currentSalary;

    @NotBlank(message = "Job title should not be blank")
    String jobTitle;
}
