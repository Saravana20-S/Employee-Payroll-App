
package com.epa.payrollGen;

import com.epa.empRegistration.Employee;
import com.epa.empRegistration.UserAccount;

public class UseCase3PayrollApp {
    public static void main(String[] args) {
        System.out.println("=== USE CASE 3: PAYROLL GENERATION ===\n");

        // 1. Setup a dummy target employee representation context
        UserAccount mockAccount = new UserAccount("abi_bridgelabz", "password");
        Employee employee = new Employee("EMP-0001", "Abhisheak", "abhisheak@bridgelabz.com", "9875642158", mockAccount);

        // 2. Build the Payslip using the chain pattern structure
        Payslip payslip = new Payslip()
                .forEmployee(employee)
                .withBasicSalary(50000.00)
                .withHra(20000.00)
                .withAllowances(15000.00)
                .withPfDeduction(6000.00)
                .withTaxDeduction(7500.00)
                .build();

        // 3. Print out to match the stylized console layout
        System.out.println(payslip);
    }
}