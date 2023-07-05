/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.HRPlus.controller;

import com.project.HRPlus.entity.Employee;
import com.project.HRPlus.entity.User;
import com.project.HRPlus.repository.UserRepository;
import com.project.HRPlus.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired(required = true)
    private UserRepository userRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login"; // login.html
    }
    
    @PostMapping("/home")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        String userId = user.getUserId();
        Optional<User> userdata = userRepository.findById(userId);
        if(user.getPassword().equals(userdata.get().getPassword())) {
            List<Employee> employeeList = employeeService.getAllEmployee();
            model.addAttribute("employee", employeeList);
            return "home";
        } else {
            return "error";
        }
    }
}
