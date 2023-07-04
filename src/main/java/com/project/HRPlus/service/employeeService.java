
package com.project.HRPlus.service;

import com.project.HRPlus.entity.Employee;
import com.project.HRPlus.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeService {
    
    @Autowired
    private employeeRepository employeeRepository;
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
