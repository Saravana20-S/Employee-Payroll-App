package com.epa.dashboard;

import com.epa.empRegistration.Employee;
import com.epa.empRegistration.UserAccount;
import com.epa.payrollGen.Payslip;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main runner class for Use Case 5.
 *
 * Role of main():
 * - Collect user input
 * - Prepare data
 * - Request appropriate dashboard
 * - Display dashboard
 *
 * @author Developer
 * @version 5.0
 */
public class UseCase5DashboardApp {

    /**
     * Entry point for dashboard display.
     *
     * Execution Flow:
     * 1. Capture employee details
     * 2. Prepare payslip data
     * 3. Select dashboard at runtime
     * 4. Display dashboard output
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// ==========================================
// STEP 1: Capture employee details
// ==========================================
        System.out.println("--- Employee Payroll App: UC5 Dashboard Initialization ---");

        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        UserAccount account = new UserAccount(username, password);

        Employee employee = new Employee(
                empId,
                name,
                email,
                phone,
                account
        );

        // ==========================================
        // STEP 2: Prepare mock payslip data using your Builder Pattern
        // ==========================================
        ArrayList<Payslip> payslips = new ArrayList<>();

        // Mocking 3 payslips to verify sorting, top 3 display logic, and year-to-date accumulation
        payslips.add(new Payslip().forEmployee(employee).withBasicSalary(50000).withHra(20000).withAllowances(10000).withPfDeduction(4000).withTaxDeduction(5000).build());
        payslips.add(new Payslip().forEmployee(employee).withBasicSalary(55000).withHra(22000).withAllowances(12000).withPfDeduction(4500).withTaxDeduction(6000).build());
        payslips.add(new Payslip().forEmployee(employee).withBasicSalary(48000).withHra(18000).withAllowances(9000).withPfDeduction(3800).withTaxDeduction(4500).build());
        payslips.add(new Payslip().forEmployee(employee).withBasicSalary(60000).withHra(24000).withAllowances(15000).withPfDeduction(5000).withTaxDeduction(7500).build());

        // ==========================================
        // STEP 3: Select dashboard type at runtime
        // ==========================================
        System.out.println("\nSelect Dashboard View Type:");
        System.out.println("1. Employee View");
        System.out.println("2. Manager View");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        String dashboardType = (choice == 2) ? "MANAGER" : "EMPLOYEE";

        // Request appropriate dashboard through the Factory
        Dashboard dashboard = DashBoardFactory.getDashboard(dashboardType);

        // ==========================================
        // STEP 4: Display dashboard output
        // ==========================================
        if (dashboard != null) {
            dashboard.display(payslips, employee);
        } else {
            System.out.println("Error: Dashboard strategy implementation could not be resolved.");
        }

        scanner.close();
    }
}