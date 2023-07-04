
package com.project.HRPlus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class employeeController {
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/addemployee")
    public String addEmployee() {
        return "add_employee";
    }
}
