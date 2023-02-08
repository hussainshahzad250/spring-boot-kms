package com.sas.kms.mapper;

import com.sas.kms.dto.EmployeeDTO;
import com.sas.kms.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmployeeMapper {

    public Employee asEntity(EmployeeDTO dto) {
        if (dto == null)
            return null;
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setMobile(dto.getMobile());
        employee.setDesignation(dto.getDesignation());
        employee.setCreatedOn(dto.getCreatedOn());
        return employee;
    }

    public EmployeeDTO asResponse(Employee dto) {
        if (dto == null)
            return null;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(dto.getId());
        employeeDTO.setFirstName(dto.getFirstName());
        employeeDTO.setLastName(dto.getLastName());
        employeeDTO.setEmail(dto.getEmail());
        employeeDTO.setMobile(dto.getMobile());
        employeeDTO.setDesignation(dto.getDesignation());
        employeeDTO.setCreatedOn(dto.getCreatedOn());
        return employeeDTO;
    }

    public List<EmployeeDTO> asResponseList(List<Employee> responses) {
        if (CollectionUtils.isEmpty(responses))
            return Collections.emptyList();
        return responses.parallelStream().map(this::asResponse).collect(Collectors.toList());
    }
}