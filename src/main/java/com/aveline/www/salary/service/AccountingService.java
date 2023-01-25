package com.aveline.www.salary.service;

import com.aveline.www.salary.db.entity.SalaryEntity;
import com.aveline.www.salary.db.repository.SalaryEntityRepository;
import com.aveline.www.salary.proxy.EmployeeServiceProxy;
import com.aveline.www.salary.proxy.WorkHourServiceProxy;
import com.aveline.www.salary.model.WorkHourRequest;
import com.aveline.www.salary.model.EmployeeLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountingService {
    @Autowired
    private EmployeeServiceProxy employeeService;

    @Autowired
    private WorkHourServiceProxy workHourService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalaryEntityRepository salaryEntityRepository;

    public SalaryEntity calculateSalary(WorkHourRequest request) {
        SalaryEntity salary;
        Number amount = null;
        //try {
            Number baseSalary = employeeService.getEmployee(request.getEmployeeId()).getBaseSalary();
            EmployeeLeave leave = restTemplate.postForObject("http://localhost:8085/employeeleave/find",request,EmployeeLeave.class);
//            EmployeeLeave leave = workHourService.getEmployeeLeave(request).get();
            if(leave == null){
                amount = baseSalary;
            }else {
                Number leaveCount = leave.getCount();
                Number daysInMonth = calculateDaysInMonth(request.getYearMonth());
                amount = (baseSalary.intValue()) * (daysInMonth.intValue() - leaveCount.intValue()) / daysInMonth.intValue();
            }
       // } catch (Exception e) {
          //  e.printStackTrace();
        //}

        salary = new SalaryEntity.SalaryEntityBuilder()
                .setEmployeeId(request.getEmployeeId())
                .setYearMonth(request.getYearMonth())
                .setAmount(amount)
                .build();

//        salaryEntityRepository.save(salary);

        return salary;
    }

    private Number calculateDaysInMonth(Number yearMonth) {
        int year = Integer.parseInt(("" + yearMonth.intValue()).substring(0, 4));
        int month = yearMonth.intValue() % 100;
        return getDays(year,month);
    }

    private Number getDays(int year, int month){
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }
}
