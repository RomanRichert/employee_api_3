package org.acme.service.impl;

import org.acme.dto.EmployeeResponseDTO;
import org.acme.entity.Employee;
import org.acme.mapper.EmployeeMapper;
import org.acme.mapper.EmployeeMapperImpl;
import org.acme.repository.EmployeeRepository;
import org.acme.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.acme.util.DtoCreator.getEmployeeCreatingDTO;
import static org.acme.util.DtoCreator.getEmployeeResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test class for EmployeeServiceImpl")
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Spy
    private EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Tests getting requested employee")
    void getEmployee() {
        // when(employeeMapper.toDTO(EntityCreator.getEmployee())).thenReturn(getEmployeeResponseDTO()); der Mapper funktioniert nicht :(
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(EntityCreator.getEmployee()));

        assertEquals(getEmployeeResponseDTO() ,employeeService.getEmployee(4), "Employees should be equals");

        verify(employeeRepository).findById(anyInt());

    }

    @Test
    @DisplayName("Tests getting all employees")
    void getAllEmployees() {
        List<Employee> employees = List.of(EntityCreator.getEmployee());
        List<EmployeeResponseDTO> employeeResponseDTOList = List.of(getEmployeeResponseDTO());

        when(employeeRepository.findAll()).thenReturn(employees);

        assertEquals(employeeResponseDTOList, employeeService.getAllEmployees(), "Lists should be equals");

        verify(employeeRepository).findAll();
    }

    @Test
    void createEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(EntityCreator.getEmployee());

        assertEquals(getEmployeeResponseDTO(), employeeService.createEmployee(getEmployeeCreatingDTO()), "Employees should be equals");

        verify(employeeRepository).save(any());
    }
}