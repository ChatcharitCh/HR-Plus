
package com.project.HRPlus.controller;

import com.project.HRPlus.entity.Employee;
import com.project.HRPlus.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {
    
    
    @Autowired
    private EmployeeService employeeService;
    

    @GetMapping("/home")
    public String home(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employee", employeeList);
        return "home";
    }
    
    @GetMapping("/addemployee")
    public String addEmployee() {
        return "add_employee";
    }
    
    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee) {
        
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }
    
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model model) {
        
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }
    
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        
        employeeService.deleteEmployee(id);
        return "redirect:/home";
    }
    
    
}
