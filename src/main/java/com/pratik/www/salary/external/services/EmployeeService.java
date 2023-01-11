package com.pratik.www.salary.external.services;

import com.pratik.www.salary.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeService {
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId);
}
