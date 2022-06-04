package com.crud.demo.controller;

import com.crud.demo.model.Employee;
import com.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeControl {
  @Autowired
  EmployeeService service;

  @GetMapping
  public String home(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
    return renderData(0, model, "id", "asc", keyword);
  }

  @GetMapping("/{page}/{property}/{direction}")
  public String renderData(
      @PathVariable(name = "page") int page,
      Model model,
      @PathVariable(name = "property") String property,
      @PathVariable(name = "direction") String direction,
      @RequestParam(name = "keyword", required = false) String keyword) {
    Page<Employee> data = service.findAll(page, 40, property, direction);

    // Pagination
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPage", data.getTotalPages() - 1);

    // Search
    if (keyword == null) {
      model.addAttribute("employees", data.getContent());
    } else {
      model.addAttribute("employees", service.search(keyword));
      model.addAttribute("keyword", keyword);
    }

    // Sort
    model.addAttribute("property", property);
    model.addAttribute("direction", direction);
    model.addAttribute("reverse", "asc".equals(direction) ? "desc" : "asc");
    return "home";
  }
}