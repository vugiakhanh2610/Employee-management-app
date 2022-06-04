package com.crud.demo.controller;

import com.crud.demo.model.Employee;
import com.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class SaveControl {
  @Autowired
  EmployeeService service;

  @PostMapping
  public String save(@ModelAttribute Employee employee) {
    service.save(employee);
    return "redirect:/";
  }
}
