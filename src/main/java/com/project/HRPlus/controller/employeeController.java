
package com.project.HRPlus.controller;

import com.project.HRPlus.entity.Employee;
import com.project.HRPlus.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class employeeController {
    @Autowired
    private employeeService employeeService;
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/addemployee")
    public String addEmployee() {
        return "add_employee";
    }
    
    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee) {
        
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
}
