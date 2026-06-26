package com.epa.empAuthlogin;

public class UseCase2LoginApp {

    /**
     * Entry point for authentication use case.
     */
    public static void main(String[] args) {

        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        // Instantiate the authentication workflow service coordinator
        AuthenticationService auth = new AuthenticationService();

        // Execute the console input flow collection sequence and evaluate credentials
        Session session = auth.login();

        // Handle session validation check based on workflow results
        if (session != null) {
            // Print the overridden toString() statement of the active session
            System.out.println(session);

            // Explicitly confirm execution state contexts are active and valid
            if (!session.isExpired()) {
                System.out.println("Session active and valid.");
            } else {
                System.out.println("Session has expired.");
            }
        } else {
            System.out.println("Login Failed.");
        }
    }
}