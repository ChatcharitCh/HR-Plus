
package com.project.HRPlus.repository;

import com.project.HRPlus.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface employeeRepository extends JpaRepository<Employee, Integer>{
    
}
