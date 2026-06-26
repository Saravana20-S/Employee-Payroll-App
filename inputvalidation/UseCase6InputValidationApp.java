package com.epa.inputvalidation;

import com.epa.empRegistration.Employee;
import com.epa.empRegistration.UserAccount;

import java.util.Scanner;

/**
 * Main runner class for Use Case 6.
 *
 * Role of main():
 * - Read user input
 * - Validate each field
 * - Stop immediately if validation fails
 * - Proceed only when all inputs are valid
 *
 * @author Developer
 * @version 6.0
 */
public class UseCase6InputValidationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6 : INPUT VALIDATION ===");

        try {

            System.out.print("Enter Employee ID : ");
            String empId = sc.nextLine();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Phone : ");
            String phone = sc.nextLine();

            System.out.print("Enter Username : ");
            String username = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            // Validate input
            ValidationService.validateEmployeeId(empId);
            ValidationService.validateEmail(email);
            ValidationService.validatePhone(phone);
            ValidationService.validatePassword(password);

            // Create objects only after successful validation
            UserAccount account = new UserAccount(username, password);

            Employee employee = new Employee(
                    empId,
                    name,
                    email,
                    phone,
                    account
            );

            System.out.println("\nEmployee Registered Successfully!\n");
            System.out.println(employee);

        }
        catch (ValidationException ex) {

            System.out.println("\nValidation Failed:");
            System.out.println(ex.getMessage());

        }

        sc.close();
    }
}