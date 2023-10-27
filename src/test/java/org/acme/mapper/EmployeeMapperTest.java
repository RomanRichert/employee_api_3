package org.acme.mapper;

import org.acme.dto.EmployeeResponseDTO;
import org.acme.entity.Employee;
import org.acme.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.acme.util.DtoCreator.getEmployeeCreatingDTO;
import static org.acme.util.DtoCreator.getEmployeeResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test class for EmployeeMapper")
public class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Test
    @DisplayName("Testing of mapping of a EmployeeCreatingDTO to Employee")
    void toEntity() {
        assertEquals(EntityCreator.getEmployee(), employeeMapper.toEntity(getEmployeeCreatingDTO()),
                "Something went wrong by mapping EmployeeCreatingDTO to Employee");
    }

    @Test
    @DisplayName("Testing of mapping of a EmployeeDTO to Employee")
    void toDto() {
        assertEquals(getEmployeeResponseDTO(), employeeMapper.toDTO(EntityCreator.getEmployee()),
                "Something went wrong by mapping Employee to EmployeeResponseDTO");
    }

    @Test
    @DisplayName("Tests mapping of a list of Employees to a list of EmployeeResponseDTOs")
    void employeesToDTOs() {
        List<Employee> employees = new ArrayList<>();
        employees.add(EntityCreator.getEmployee());

        List<EmployeeResponseDTO> dtos = new ArrayList<>();
        dtos.add(getEmployeeResponseDTO());

        assertEquals(dtos, employeeMapper.employeesToDTOs(employees),
                "Something went wrong by mapping of a list of Employees to a list of EmployeeResponseDTOs");
    }
}
