package com.sas.kms.service;

import com.sas.kms.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee entity);

    List<Employee> saveAll(List<Employee> entities);

    void deleteById(Long id);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee update(Employee entity, Long id);
}
