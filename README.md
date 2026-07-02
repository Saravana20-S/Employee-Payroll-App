# Employee Payroll Application

A robust, enterprise-grade Java application designed for processing corporate payroll structures, handling authentication, automating custom payslip distribution engines, and delivering specialized analytic dashboards. Built following SOLID architectural design principles and structural software engineering design patterns.

---

## 🛠 Project Architecture & Architecture Layers

The system uses a decoupled, package-by-feature hierarchy separating domains, registration steps, payroll engines, and dynamic polymorphic formatting structures.

com.epa
├── dashboard          # UC5: Polymorphic User & Manager View Strategy (Factory Pattern)
├── empAuthLogin       # UC2: Employee Security & Authentication Services
├── empRegistration    # UC1: Core Registration domain model, validations, and storage
├── message            # Utility alerting and cross-layer notification hooks
├── payrollGen         # UC4: Fluent-interface processing engines & math streams
└── payslipPrint       # UC3: Formatting engines and dynamic file text generator

## 📌 Feature Milestone Roadmap (Use Cases)

Based on our iterative release roadmap, the codebase includes the following functional milestones:

### 🔹 UC1: Employee Registration
* Implements robust identity tracking models with independent lifetimes (`Employee` domain aggregation).
* Stores unique keys: Employee ID, Name, secure corporate Email, and structural serialization helpers (`toFileString()`).

### 🔹 UC2: Authentication & Security Controls
* Secure data isolation encapsulation utilizing the dedicated `UserAccount` bridge entity.
* Prevents raw string cleartext exposure via integrated custom structural credential protection schemes.

### 🔹 UC3: Dedicated Employee Slip Logic
* Formats raw memory domains to clear, localized tabular structures.
* Implements persistent IO hooks using flat file operations to save individual generated ledger datasets (`employee_data.txt`).

### 🔹 UC4: Modern Stream API Payroll Calculation 
* Uses **Fluent Interface Method Chaining (Builder Pattern Variant)** for building complex instances dynamically safely.
* Uses the modern Java **Stream API (`DoubleStream`)** to map complex allowances, income taxes, provident funds (PF), and calculate structural elements cleanly down to net pay metrics.

### 🔹 UC5: Runtime Dynamic Dashboard View (Factory & Strategy Pattern)
* Fully unties dependencies through an abstract `Dashboard` functional contract layer.
* Dynamic polymorphism calculates a rolling **Year-to-Date (YTD) Cumulative Gross Value** and performs high-performance descending `Comparator` ranking to reveal **Top 3 Most Recent Payslips** asynchronously.
* Provides dual structural views:
  1. `EmployeeDashboard` — Tailored personalized views.
  2. `ManagerDashboard` — Broad cross-department management analytics dashboards.

### 🔹 UC6: Advanced Boundary Input Validation
* Protects core data persistence routines from corrupt string values.
* Extends verification constraints across parameters safely before updating internal system states.

---

## 💻 Technical Design Patterns Demonstrated

1. **Fluent Interface / Builder Pattern Variant:** Found inside `Payslip.java` allowing safe initialization loops via explicit `.forEmployee()`, `.withBasicSalary()`, and terminal `.build()` hooks preventing partial entity leaks.
2. **Simple Factory Architectural Pattern:** Found in `DashBoardFactory.java` to instantiate context-dependent interface implementations at execution time without hardcoding concrete types.
3. **Strategy-like Interface Decoupling:** Isolating view contracts using `interface Dashboard` matching optimal structural decoupling guidelines.
4. **Aggregation vs. Composition Realization:** Explicit clean separation between `Employee` life cycles (Aggregation link) and localized transient properties like `SalaryComponents` (Composition link).

---

## 🚀 Execution & Quick Start Guide

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher (JDK 11+ recommended for enhanced Stream interactions).
* **IDE Support:** IntelliJ IDEA or Eclipse.

### Compilation
Navigate to your project root subdirectory containing the source directories and execute:

javac -d out src/com/epa/empRegistration/*.java src/com/epa/payrollGen/*.java src/com/epa/dashboard/*.java
Execution (Use Case 5 Runner App Entry Point)
Run the dynamic initialization console application:

Bash
java -cp out com.epa.dashboard.UseCase5DashboardApp
📊 Core Data Entities Overview
Employee Domain Model
Java
public class Employee {
    private String empId;
    private String name;
    private String email;
    private String phone;
    private UserAccount account;
    
    // Custom file persistent export operations
    public String toFileString() { ... }
}

📝 Continuous Integration Commit History Summary
feat: UC6 Input validation added

feat: UC5 Added Dashboard feature

feat: UC4 Payslip Generation Logic added

UC3: Added Employee Slip Logic

feat: Added employee authentication

feat: added Employee Registration

feat: Welcome to Employee Payroll App

Developed as part of the Java Engineering Fellowship Initiative
