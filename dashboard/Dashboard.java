package com.epa.dashboard;

import com.epa.empRegistration.Employee;
import com.epa.payrollGen.Payslip;

import java.util.ArrayList;

/**
 * Dashboard defines a common contract for all dashboards.
 *
 * Why an interface:
 * - Different dashboards exist
 * - All dashboards must provide a display() method
 * - Caller should not depend on concrete implementations
 */
public interface Dashboard {

    void display(ArrayList<Payslip> payslips, Employee employee);

}