package com.aveline.www.salary.proxy;

import com.aveline.www.salary.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeServiceProxy {
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId);
}
