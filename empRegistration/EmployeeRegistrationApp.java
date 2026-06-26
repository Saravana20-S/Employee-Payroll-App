package com.epa.empRegistration;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeRegistrationApp {


    public static void main(String[] args) throws ValidationException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== USE CASE 1: Employee Registration ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = scanner.nextLine().trim();
            Validator.validateEmpId(empId);

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            Validator.validateEmail(email);

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = scanner.nextLine().trim();
            Validator.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Create Password: ");
            String password = scanner.nextLine().trim();

            // 2. Create Objects (Composition)
            UserAccount account = new UserAccount(username, password);
            Employee employee = new Employee(empId, name, email, phone, account);

            // 3. Persist Data to File
            persistEmployeeData(employee);

            // 4. Confirm / Output Output
            System.out.println("\n-------------------------------------");
            System.out.println("Employee Registered Successfully:");
            System.out.println(employee); // Calls overridden toString()
            System.out.println("\nData persisted in file: employee_data.txt");
            System.out.println("-------------------------------------");

        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }

    }

    private static void persistEmployeeData(Employee emp) throws IOException {
        // open file in append mode (true)
        try (FileWriter fw = new FileWriter("employee_data.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(emp.toFileString());
        }
    }
}

