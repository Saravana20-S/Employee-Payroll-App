package com.epa.payrollGen;

import com.epa.empRegistration.Employee; // Aggregation link
import java.util.stream.DoubleStream;

/**
 * Models the core Payslip business entity.
 * Implements a Fluent Interface design pattern for method chaining.
 */
public class Payslip {
    private Employee employee;          // Aggregation: Can exist independently
    private SalaryComponents components; // Composition: Owned tightly by Payslip

    // Temporary building fields
    private double basicSalary;
    private double hra;
    private double allowances;
    private double pf;
    private double tax;

    public double getGrossSalary() {
        return calculateGrossSalary();
    }

    public double getTotalDeductions() {
        return calculateTotalDeductions();
    }

    public double getNetPay() {
        return calculateNetPayable();
    }

    public Employee getEmployee() {
        return employee;
    }

    public SalaryComponents getSalaryComponents() {
        return components;
    }

    // Fluent Interface Pattern
    public Payslip forEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Payslip withBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
        return this;
    }

    public Payslip withHra(double hra) {
        this.hra = hra;
        return this;
    }

    public Payslip withAllowances(double allowances) {
        this.allowances = allowances;
        return this;
    }

    public Payslip withPfDeduction(double pf) {
        this.pf = pf;
        return this;
    }

    public Payslip withTaxDeduction(double tax) {
        this.tax = tax;
        return this;
    }

    // Terminal method to assemble internal structural items
    public Payslip build() {
        this.components = new SalaryComponents(basicSalary, hra, allowances, pf, tax);
        return this;
    }

    /**
     * Requirements: Compute calculation components using the Stream API
     */
    public double calculateGrossSalary() {
        return DoubleStream.of(components.getBasicSalary(), components.getHra(), components.getAllowances()).sum();
    }

    public double calculateTotalDeductions() {
        return DoubleStream.of(components.getPf(), components.getTax()).sum();
    }

    public double calculateNetPayable() {
        return calculateGrossSalary() - calculateTotalDeductions();
    }

    @Override
    public String toString() {
        return "==================================================\n" +
                "                MONTHLY PAYSLIP                   \n" +
                "==================================================\n" +
                "Employee ID    : " + (employee != null ? employee.getEmpId() : "N/A") + "\n" +
                "Name           : " + (employee != null ? employee.getName() : "N/A") + "\n" +
                "Email          : " + (employee != null ? employee.getEmail() : "N/A") + "\n" +
                "--------------------------------------------------\n" +
                "EARNINGS                           DEDUCTIONS     \n" +
                "--------------------------------------------------\n" +
                String.format("Basic Salary   : INR %-13.2f Provident Fund : INR %.2f\n", components.getBasicSalary(), components.getPf()) +
                String.format("HRA            : INR %-13.2f Income Tax     : INR %.2f\n", components.getHra(), components.getTax()) +
                String.format("Allowances     : INR %-13.2f\n", components.getAllowances()) +
                "--------------------------------------------------\n" +
                String.format("Gross Salary   : INR %-13.2f Total Deduct. : INR %.2f\n", calculateGrossSalary(), calculateTotalDeductions()) +
                "--------------------------------------------------\n" +
                String.format("NET PAYABLE    : INR %.2f\n", calculateNetPayable()) +
                "==================================================";
    }
}