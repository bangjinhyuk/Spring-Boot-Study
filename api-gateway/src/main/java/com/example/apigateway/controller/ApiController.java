package com.example.apigateway.controller;

import com.example.apigateway.model.Employee;
import com.example.apigateway.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
        * GET http://localhost:8080/api/v1/employees
        * GET http://localhost:8080/api/v1/employees/{id}
        * POST http://localhost:8080/api/v1/employees
        * PUT http://localhost:8080/api/v1/employees/{id}
        * DELETE http://localhost:8080/api/v1/employees/{id}
*/
@CrossOrigin(origins = "http://localhost:4040")
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable(value = "id") Long employeeId ){
        Employee employee = employeeRepository.getById(employeeId);
        return ResponseEntity.ok(employee);
    }
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
        }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.getById(employeeId);
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastname(employeeDetails.getLastname());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
    {
        Employee employee = employeeRepository.getById(employeeId);

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
