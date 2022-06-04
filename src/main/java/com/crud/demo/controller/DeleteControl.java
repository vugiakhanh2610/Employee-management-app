package com.crud.demo.controller;

import com.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete/{id}")
public class DeleteControl {
  @Autowired
  EmployeeService service;

  @GetMapping
  public String delete(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/";
  }
}