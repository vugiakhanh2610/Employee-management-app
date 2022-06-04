package com.crud.demo.controller;

import com.crud.demo.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class AddControl {

  @GetMapping
  public String add(Model model) {
    model.addAttribute(new Employee());
    return "form";
  }
}