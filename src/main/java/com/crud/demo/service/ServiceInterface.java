package com.crud.demo.service;

import java.util.List;

import com.crud.demo.model.Employee;

import org.springframework.data.domain.Page;

public interface ServiceInterface {
  public void save(Employee employee);

  public Employee findById(int id);

  public void delete(int id);

  public Page<Employee> findAll(int page, int size, String property, String direction);

  public List<Employee> search(String keyword);
}