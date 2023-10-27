package org.acme.util;

import lombok.experimental.UtilityClass;
import org.acme.dto.EmployeeCreatingDTO;
import org.acme.dto.EmployeeResponseDTO;
import org.acme.entity.Employee;

import static org.acme.util.EntityCreator.getEmployee;

@UtilityClass
public class DtoCreator {

    public static EmployeeResponseDTO getEmployeeResponseDTO() {
        Employee employee = getEmployee();

        return new EmployeeResponseDTO(
                employee.getId().toString(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getCurrentSalary().toString(),
                employee.getJobTitle()
        );
    }

    public static EmployeeCreatingDTO getEmployeeCreatingDTO() {
        return new EmployeeCreatingDTO("Anna", "Richert", 100500.99, "Romans Frau");
    }
}
