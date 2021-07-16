package com.example.apigateway.repository;

import com.example.apigateway.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
