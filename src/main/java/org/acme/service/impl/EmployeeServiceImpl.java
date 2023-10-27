package org.acme.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.dto.EmployeeCreatingDTO;
import org.acme.dto.EmployeeResponseDTO;
import org.acme.exception.EmployeeNotFoundException;
import org.acme.mapper.EmployeeMapper;
import org.acme.repository.EmployeeRepository;
import org.acme.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.acme.exception.ErrorMessage.EMPLOYEE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDTO getEmployee(Integer id) {
        return employeeMapper.toDTO(employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND.getMessage() + id)));
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeMapper.employeesToDTOs(employeeRepository.findAll());
    }

    @Override
    @Transactional
    public EmployeeResponseDTO createEmployee(EmployeeCreatingDTO employeeCreatingDTO) {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employeeCreatingDTO)));
    }
}