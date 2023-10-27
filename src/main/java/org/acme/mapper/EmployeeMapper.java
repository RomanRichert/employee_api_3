package org.acme.mapper;

import org.acme.dto.EmployeeCreatingDTO;
import org.acme.dto.EmployeeResponseDTO;
import org.acme.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface EmployeeMapper { //mapper funktioniert nicht :(

    EmployeeResponseDTO toDTO(Employee employee);

    Employee toEntity(EmployeeCreatingDTO employeeCreatingDTO);

    List<EmployeeResponseDTO> employeesToDTOs(List<Employee> employeeList);
}
