package com.sas.kms.controller;

import com.sas.kms.dto.EmployeeDTO;
import com.sas.kms.entity.Employee;
import com.sas.kms.mapper.EmployeeMapper;
import com.sas.kms.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asResponse(employeeService.save(employee));
    }


    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return employeeMapper.asResponse(employee);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }


    @GetMapping
    public List<EmployeeDTO> list() {
        return employeeMapper.asResponseList(employeeService.findAll());
    }


    @GetMapping("/page-query")
    public Page<EmployeeDTO> pageQuery(Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        List<EmployeeDTO> dtoList = employeePage
                .stream()
                .map(employeeMapper::asResponse).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, employeePage.getTotalElements());
    }


    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Long id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asResponse(employeeService.update(employee, id));
    }
}