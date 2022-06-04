package com.crud.demo.repository;

import java.util.List;

import com.crud.demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  
  @Query("SELECT e FROM Employee e where CONCAT(e.id,' ',e.firstName,' ',e.lastName,' ',e.gender,' ',e.department,' ',e.country) LIKE %?1%")
	public List<Employee> search(String keyword);
}
