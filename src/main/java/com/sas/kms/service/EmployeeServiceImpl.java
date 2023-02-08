package com.sas.kms.service;

import com.sas.kms.dao.EmployeeRepository;
import com.sas.kms.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;


    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public List<Employee> saveAll(List<Employee> entities) {
        return (List<Employee>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> entityPage = repository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Employee update(Employee entity, Long id) {
        Optional<Employee> optional = findById(id);
        if (optional.isPresent()) {

        }
        return null;
    }
}