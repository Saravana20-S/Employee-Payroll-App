package com.epa.payslipPrint;

/**
 * Service orchestrator responsible for managing file print and download operations.
 * Ensures the original data integrity via object cloning before streaming.
 */
public class FileService {

    private final DownloadStream downloadStream;

    public FileService() {
        this.downloadStream = new DownloadStream();
    }

    /**
     * Prints or downloads an independent copy of a payslip.
     * Implements cloning to protect the integrity of the original object reference.
     * * @param originalPayslip The source immutable payslip object
     */
    public void printPayslip(Payslip originalPayslip) {
        System.out.println("[INFO]: Initiating secure printing process...");

        // 1. Create an independent, detached copy using the overridden clone method
        Payslip clonedPayslip = originalPayslip.clone();

        // 2. Capture the exact generation initiation timestamp
        long generationTime = System.currentTimeMillis();

        // 3. Delegate to the DownloadStream to perform File I/O operations safely
        downloadStream.download(clonedPayslip, generationTime);
    }
}