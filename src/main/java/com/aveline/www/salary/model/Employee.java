package com.aveline.www.salary.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@JsonDeserialize(builder = Employee.EmployeeBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    private String id;
    private String name;
    private String deptName;
    private String address;
    @JsonIgnore
    private Date joiningDate;
    private int baseSalary;

    public Employee() {}

    public Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.deptName = builder.deptName;
        this.address = builder.address;
        this.joiningDate = builder.joiningDate;
        this.baseSalary = builder.baseSalary;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getAddress() {
        return address;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", address='" + address + '\'' +
                ", joiningDate=" + joiningDate +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeBuilder {
        protected String id;
        protected String name;
        protected String deptName;
        protected String address;
        @JsonIgnore
        protected Date joiningDate;
        protected int baseSalary;

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setJoiningDate(Date joiningDate) {
            this.joiningDate = joiningDate;
            return this;
        }

        public EmployeeBuilder setBaseSalary(int baseSalary) {
            this.baseSalary = baseSalary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
