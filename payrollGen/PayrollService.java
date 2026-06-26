package com.epa.payrollGen;

import com.epa.empRegistration.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class handling core payroll operations.
 * Key Concepts:
 * - Stream API for bulk processing and calculations
 * - Core business logic orchestration
 */
public class PayrollService {

    private List<Payslip> payslips;

    public PayrollService() {
        this.payslips = new ArrayList<>();
    }

    /**
     * Generates and registers a payslip using the Fluent Interface pattern.
     */
    public Payslip generatePayslip(Employee employee, double basic, double hra, double allowances, double pf, double tax) {
        Payslip payslip = new Payslip()
                .forEmployee(employee)
                .withBasicSalary(basic)
                .withHra(hra)
                .withAllowances(allowances)
                .withPfDeduction(pf)
                .withTaxDeduction(tax)
                .build();

        // Track generated payslips internally
        payslips.add(payslip);
        return payslip;
    }

    /**
     * Requirement: Use Stream API to calculate total net outflow across all generated payslips.
     */
    public double calculateTotalNetOutflow() {
        return payslips.stream()
                .mapToDouble(Payslip::calculateNetPayable)
                .sum();
    }

    /**
     * Requirement: Use Stream API to calculate total tax deductions collected.
     */
    public double calculateTotalTaxCollected() {
        return payslips.stream()
                .mapToDouble(p -> p.calculateTotalDeductions()) // or map directly if exposed
                .sum();
    }

    /**
     * Displays all tracked payslips in the system.
     */
    public void printAllPayslips() {
        if (payslips.isEmpty()) {
            System.out.println("No payslips have been generated yet.");
            return;
        }
        payslips.forEach(System.out::println);
    }
}