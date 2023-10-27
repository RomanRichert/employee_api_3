package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class EmployeeResponseDTO {

    String id;

    String firstName;

    String lastName;

    String currentSalary;

    String jobTitle;
}