package com.epa.payslipPrint;

public class UseCase4PrintApp {

    public static void main(String[] args) {
        System.out.println("=== USE CASE 4: PAYSLIP PRINT & DOWNLOAD ===");

        // 1. Instantiating original immutable records
        Payslip originalPayslip1 = new Payslip("EMP001", "Abhisheak", "June 2026", 76500.00);
        Payslip originalPayslip2 = new Payslip("EMP002", "Rahul", "June 2026", 82000.00);

        System.out.println("\n[SETUP]: Loaded original records successfully.");
        System.out.println("Original 1: " + originalPayslip1);
        System.out.println("Original 2: " + originalPayslip2);

        // 2. Demonstrating Object Comparison (equals & hashCode Contract)
        System.out.println("\n--- Object Equality Testing ---");
        Payslip duplicatePayslip = new Payslip("EMP001", "Abhisheak", "June 2026", 76500.00);

        boolean areEqual = originalPayslip1.equals(duplicatePayslip);
        System.out.println("Is Original 1 structurally equal to Duplicate record? " + areEqual);
        System.out.println("Original 1 HashCode : " + originalPayslip1.hashCode());
        System.out.println("Duplicate  HashCode : " + duplicatePayslip.hashCode());

        // 3. Testing data isolation via Deep/Safe Cloning
        System.out.println("\n--- Cloning & Integrity Verification ---");
        Payslip clonedPayslip = originalPayslip1.clone();
        System.out.println("Cloned Instance Copy: " + clonedPayslip);
        System.out.println("Are references identical? (originalPayslip1 == clonedPayslip): " + (originalPayslip1 == clonedPayslip));
        System.out.println("Are contents structurally equal?: " + originalPayslip1.equals(clonedPayslip));

        // 4. File I/O print generation execution sequence
        System.out.println("\n--- Initiating File I/O Operations ---");
        FileService fileService = new FileService();

        // This triggers cloning internally, calculates unique filenames, and saves down text segments safely.
        fileService.printPayslip(originalPayslip1);
        fileService.printPayslip(originalPayslip2);
    }
}