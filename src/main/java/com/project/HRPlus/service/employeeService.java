
package com.project.HRPlus.service;

import com.project.HRPlus.entity.Employee;
import com.project.HRPlus.repository.employeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeService {
    
    @Autowired
    private employeeRepository employeeRepository;
    
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(int id) {
        
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }
}
