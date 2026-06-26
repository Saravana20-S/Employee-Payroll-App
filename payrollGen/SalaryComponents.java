package com.epa.payrollGen;

/**
 * Key Concept: Composition
 * Payslip HAS-A SalaryComponents object.
 * This class encapsulates individual earnings and deductions.
 */
public class SalaryComponents {
    private double basicSalary;
    private double hra;
    private double allowances;
    private double pf;
    private double tax;

    public SalaryComponents(double basicSalary, double hra, double allowances, double pf, double tax) {
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.allowances = allowances;
        this.pf = pf;
        this.tax = tax;
    }

    public double getBasicSalary() { return basicSalary; }
    public double getHra() { return hra; }
    public double getAllowances() { return allowances; }
    public double getPf() { return pf; }
    public double getTax() { return tax; }
}