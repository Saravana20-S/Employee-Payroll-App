package com.epa.payslipPrint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Handles professional File I/O operations and downloads for Payslips.
 * Key Requirements Implemented:
 * - File writing operations via BufferedWriter
 * - Unique filename generation based on Employee details
 * - Download expiration safety threshold tracking
 */
public class DownloadStream {

    // Threshold constant defining how long a download token/session stays valid (e.g., 5 seconds)
    private static final long EXPIRY_THRESHOLD_MILLIS = 5000;

    /**
     * Downloads the provided immutable payslip object as a formatted text document.
     * Checks if the window is valid before executing the File I/O operations.
     * * @param payslip The immutable payslip object to save
     * @param generationTime The timestamp when this download link was initiated
     */
    public void download(Payslip payslip, long generationTime) {
        long currentTime = System.currentTimeMillis();

        // 1. Download expiry validation safety check
        if ((currentTime - generationTime) > EXPIRY_THRESHOLD_MILLIS) {
            System.err.println("[DOWNLOAD ERROR]: Failed to download. The download link/session has expired.");
            return;
        }

        // 2. Generate a unique and clean filename to maintain original data integrity
        String cleanFileName = String.format("payslip_%s_%s.txt",
                payslip.getEmpId().toLowerCase().replaceAll("[^a-zA-Z0-9_-]", ""),
                payslip.getMonth().toLowerCase());

        File outputFile = new File(cleanFileName);

        // 3. Perform File I/O operations using try-with-resources to ensure resource closure
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("==================================================\n");
            writer.write("             OFFICIAL PAYSLIP DOWNLOAD            \n");
            writer.write("==================================================\n");
            writer.write("Employee ID    : " + payslip.getEmpId() + "\n");
            writer.write("Employee Name  : " + payslip.getEmpName() + "\n");
            writer.write("Payroll Month  : " + payslip.getMonth() + "\n");
            writer.write("--------------------------------------------------\n");
            writer.write(String.format("TOTAL NET PAID : INR %.2f\n", payslip.getNetPay()));
            writer.write("==================================================\n");
            writer.write("Status         : SECURE COPY GENERATED SUCCESSFULLY\n");

            System.out.println("[SUCCESS]: Payslip saved securely to local workspace file: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("[SYSTEM ERROR]: Core I/O failure while writing file contents: " + e.getMessage());
        }
    }
}