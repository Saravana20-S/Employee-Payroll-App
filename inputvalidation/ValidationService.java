package com.epa.inputvalidation;

public class ValidationService {

    /**
     * Removes leading and trailing spaces.
     */
    private static String sanitize(String input) {
        if (input == null) {
            return "";
        }
        return input.trim();
    }

    /**
     * Validates email format.
     */
    public static void validateEmail(String email)
            throws EmailValidationException {

        email = sanitize(email);

        if (email.isEmpty()) {
            throw new EmailValidationException("Email cannot be empty.");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(emailRegex)) {
            throw new EmailValidationException("Invalid email format.");
        }
    }

    /**
     * Validates phone number.
     * Accepts exactly 10 digits.
     */
    public static void validatePhone(String phone)
            throws PhoneValidationException {

        phone = sanitize(phone);

        if (phone.isEmpty()) {
            throw new PhoneValidationException("Phone number cannot be empty.");
        }

        if (!phone.matches("\\d{10}")) {
            throw new PhoneValidationException(
                    "Phone number must contain exactly 10 digits.");
        }
    }

    /**
     * Validates password.
     * Minimum 8 characters,
     * at least one uppercase,
     * one lowercase,
     * one digit,
     * one special character.
     */
    public static void validatePassword(String password)
            throws PasswordValidationException {

        password = sanitize(password);

        if (password.isEmpty()) {
            throw new PasswordValidationException("Password cannot be empty.");
        }

        String passwordRegex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

        if (!password.matches(passwordRegex)) {
            throw new PasswordValidationException(
                    "Password must contain at least 8 characters, "
                            + "one uppercase, one lowercase, "
                            + "one digit and one special character.");
        }
    }

    /**
     * Validates Employee ID.
     * Example: EMP001
     */
    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        empId = sanitize(empId);

        if (empId.isEmpty()) {
            throw new EmployeeIdValidationException(
                    "Employee ID cannot be empty.");
        }

        if (!empId.matches("EMP\\d{3}")) {
            throw new EmployeeIdValidationException(
                    "Employee ID must be in format EMP001.");
        }
    }
}