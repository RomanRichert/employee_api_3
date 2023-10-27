package org.acme.service;

import org.acme.dto.EmployeeCreatingDTO;
import org.acme.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO getEmployee(Integer id);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO createEmployee(EmployeeCreatingDTO employeeCreatingDTO);
}
