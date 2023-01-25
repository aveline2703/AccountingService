package com.aveline.www.salary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;



@JsonDeserialize(builder = WorkHourRequest.WorkHourRequestBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkHourRequest {
    private String employeeId;
    private Number yearMonth;

    public WorkHourRequest() {
    }

    public WorkHourRequest(WorkHourRequestBuilder builder) {
        this.employeeId = builder.employeeId;
        this.yearMonth = builder.yearMonth;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    @Override
    public String toString() {
        return "WorkHourRequest{" +
                "employeeId='" + employeeId + '\'' +
                ", yearMonth=" + yearMonth +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class WorkHourRequestBuilder{
        protected String employeeId;
        protected Number yearMonth;

        public WorkHourRequest.WorkHourRequestBuilder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public WorkHourRequest.WorkHourRequestBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public WorkHourRequest build() {
            return new WorkHourRequest(this);
        }
    }
}
