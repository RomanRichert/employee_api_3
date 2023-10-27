package org.acme.util;

import lombok.experimental.UtilityClass;
import org.acme.dto.EmployeeCreatingDTO;
import org.acme.entity.Employee;

import static org.acme.util.DtoCreator.getEmployeeCreatingDTO;

@UtilityClass
public class EntityCreator {

    public static Employee getEmployee() {
        EmployeeCreatingDTO employeeDTO = getEmployeeCreatingDTO();

        return new Employee(
                4,
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getCurrentSalary(),
                employeeDTO.getJobTitle()
        );
    }
}
