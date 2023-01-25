package com.aveline.www.salary.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@JsonDeserialize(builder = SalaryEntity.SalaryEntityBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    private Number yearMonth;
    private Number amount;
    private String employeeId;

    public SalaryEntity() {
    }

    public SalaryEntity(SalaryEntityBuilder builder) {
        this.yearMonth = builder.yearMonth;
        this.amount = builder.amount;
        this.employeeId = builder.employeeId;
    }

    public String getId() {
        return id;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    public Number getAmount() {
        return amount;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "SalaryEntity{" +
                "id='" + id + '\'' +
                ", yearMonth=" + yearMonth +
                ", amount=" + amount +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class SalaryEntityBuilder{
        protected String id;
        protected Number yearMonth;
        protected Number amount;
        protected String employeeId;

        public SalaryEntityBuilder setId(String id) {
            this.id = id;
            return this;
        }
        public SalaryEntityBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }
        public SalaryEntityBuilder setAmount(Number amount) {
            this.amount = amount;
            return this;
        }
        public SalaryEntityBuilder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public SalaryEntity build() {
            return new SalaryEntity(this);
        }
    }
}
