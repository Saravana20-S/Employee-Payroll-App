package com.epa.empAuthlogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {

    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    // Internal tracking map for failed attempts per username
    private Map<String, Integer> failedAttemptsTracker = new HashMap<>();

    public AuthenticationService() {
        // Pre-populating baseline mock data matching the target registration values
        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Admin@789"));
    }

    /**
     * Handles the complete login flow.
     * * Steps:
     * 1. Accept credentials
     * 2. Validate using polymorphism
     * 3. Create session
     * 4. Show dashboard
     */
    public Session login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String inputUsername = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String inputPassword = scanner.nextLine().trim();

        // Check if user has hit maximum limit lockouts
        int currentFailedCount = failedAttemptsTracker.getOrDefault(inputUsername, 0);
        if (currentFailedCount >= maxAttempts) {
            System.out.println("\n[NOTIFICATION]: Account locked due to multiple failed login attempts.");
            return null;
        }

        User user = users.get(inputUsername);

        // Step 2: Validate credentials polymorphically using the user's specific class logic
        if (user != null && user.authenticate(inputUsername, inputPassword)) {
            // Reset failed counter state context on successful match
            failedAttemptsTracker.put(inputUsername, 0);

            System.out.println("\nLogin Successful!");
            System.out.println("Role: " + user.getRole());
            System.out.println();

            // Step 4: Show the matching console panels
            showDashboard(user.getRole());

            // Step 3: Instantiate and return active validation metrics context
            return new Session(user.username);
        } else {
            // Unsuccessful match handling flow mechanics
            currentFailedCount++;
            failedAttemptsTracker.put(inputUsername, currentFailedCount);

            System.out.println("\n[NOTIFICATION]: Invalid username or password. Attempt "
                    + currentFailedCount + " of " + maxAttempts);
            return null;
        }
    }

    /**
     * Displays dashboard based on user role.
     * * Role-based behavior is introduced here
     * in a simple and readable way.
     */
    private void showDashboard(String role) {
        System.out.println("======= DASHBOARD =======");
        if ("EMPLOYEE".equalsIgnoreCase(role)) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");
        } else if ("MANAGER".equalsIgnoreCase(role)) {
            System.out.println("Manager Dashboard");
            System.out.println("Approve Payroll | View Team Reports | System Settings");
        }
        System.out.println();
    }
}