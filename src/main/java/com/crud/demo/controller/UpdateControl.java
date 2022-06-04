package com.crud.demo.controller;

import com.crud.demo.model.Employee;
import com.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update/{id}")
public class UpdateControl {
  @Autowired
  EmployeeService service;

  @GetMapping
  public String update(@PathVariable(name = "id") int id, Model model) {
    Employee employee = service.findById(id);
    model.addAttribute("employee", employee);
    return "form";
  }
}
