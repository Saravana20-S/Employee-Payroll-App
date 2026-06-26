package com.epa.payslipPrint;

import java.util.Objects;

/**
 * Making the class final prevents inheritance-based modification.
 * This class represents an immutable representation of a payslip for printing/downloads.
 */
public final class Payslip implements Cloneable {

    private final String empId;
    private final String empName;
    private final String month;
    private final double netPay;

    // Constructor initializing all final fields
    public Payslip(String empId, String empName, String month, double netPay) {
        this.empId = empId;
        this.empName = empName;
        this.month = month;
        this.netPay = netPay;
    }

    // Getters (No setters allowed to maintain absolute immutability)
    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getMonth() { return month; }
    public double getNetPay() { return netPay; }

    /**
     * Contract implementation: equals()
     * Compares structural attributes instead of reference addresses.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payslip payslip = (Payslip) o;
        return Double.compare(payslip.netPay, netPay) == 0 &&
                Objects.equals(empId, payslip.empId) &&
                Objects.equals(empName, payslip.empName) &&
                Objects.equals(month, payslip.month);
    }

    /**
     * Contract implementation: hashCode()
     * Guarantees that if two objects are equal via equals(), they share the same hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, month, netPay);
    }

    /**
     * Cloning implementation.
     * Since this class contains only immutable primitive values and immutable Strings,
     * a super.clone() shallow copy behaves identically to a deep copy safely.
     */
    @Override
    public Payslip clone() {
        try {
            return (Payslip) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed on a cloneable object structure", e);
        }
    }

    @Override
    public String toString() {
        return "Payslip [Employee ID=" + empId + ", Name=" + empName + ", Month=" + month + ", Net Pay=INR " + netPay + "]";
    }
}