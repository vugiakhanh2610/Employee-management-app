package com.crud.demo.service;

import java.util.List;

import com.crud.demo.model.Employee;
import com.crud.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements ServiceInterface {
  @Autowired
  private EmployeeRepository repository;

  @Override
  public Page<Employee> findAll(int page, int size, String property, String direction) {
    Sort sort = "asc".equalsIgnoreCase(direction) ? Sort.by(property).ascending() : Sort.by(property).descending();
    return repository.findAll(PageRequest.of(page, size, sort));
  }

  @Override
  public void save(Employee employee) {
    repository.save(employee);
  }

  @Override
  public Employee findById(int id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public void delete(int id) {
    repository.deleteById(id);
  }

  @Override
  public List<Employee> search(String keyword) {
    return repository.search(keyword);
  }
}