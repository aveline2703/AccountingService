package com.aveline.www.salary.controller;

import com.aveline.www.salary.db.entity.SalaryEntity;
import com.aveline.www.salary.model.WorkHourRequest;

import com.aveline.www.salary.service.AccountingService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounting")
public class AccountingController {

    @Autowired
    private AccountingService accountingService;

    @PostMapping("/calculateSalary")
    @CircuitBreaker(name = "calculatesalaryBreaker", fallbackMethod = "calculatesalaryFallback")
    public SalaryEntity calculateSalary(@RequestBody WorkHourRequest request){
        return this.accountingService.calculateSalary(request);
    }
    
    public SalaryEntity calculatesalaryFallback(WorkHourRequest request, Exception e) {
    	  System.out.println("Fallbcak is called because one the services is down: ");
          System.out.println(e.getMessage());
          Number baseSalary = 20000;
          SalaryEntity salary = new SalaryEntity.SalaryEntityBuilder()
                  .setEmployeeId(request.getEmployeeId())
                  .setYearMonth(request.getYearMonth())
                  .setAmount(baseSalary)
                  .build();

          return salary;
    }

//    @PostMapping("/calculateSalary/{employeeId}/{yearMonth}")
//    public Number calculateSalary(@PathVariable String employeeId, @PathVariable Number yearMonth){
//        return this.accountingService.calculateSalary(employeeId, yearMonth);
//    }
}
