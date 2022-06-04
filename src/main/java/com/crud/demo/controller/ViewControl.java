package com.crud.demo.controller;

import com.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/{id}")
public class ViewControl {
  @Autowired
  EmployeeService service;

  @GetMapping
  public String view(@PathVariable(name = "id") int id, Model model) {
    model.addAttribute("employee", service.findById(id));
    return "view";
  }
}