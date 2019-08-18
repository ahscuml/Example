package com.ahscuml.Junit.EmployTest;

import org.junit.Test;

/**
 * @author ahscuml
 * @date 2019/3/2
 * @time 19:28
 */
public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    /**
     * 测试appraisal
     * */
    @Test
    public void testCalculateAppriasal() {
        employee.setName("test");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        // what is dalta
        org.junit.Assert.assertEquals(500,appraisal,0.0);
    }

    public void testCalculateYearlySalary() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary= empBusinessLogic.calculateYearlySalary(employee);
        org.junit.Assert.assertEquals(96000, salary, 0.0);
    }
}
