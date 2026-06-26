package com.epa.empRegistration;

import java.io.IOException;

public class Employee {

    private String empId;
    private String name;
    private String email;
    private String phone;

    private UserAccount account;

    public Employee(){ }

    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Employee ID : " + empId + "\n" +
                "Name        : " + name + "\n" +
                "Email       : " + email + "\n" +
                "Phone       : " + phone + "\n" +
                "Username    : " + account.getUserName();
    }


    public String toFileString() {
        return empId + "," + name + "," + email + "," + phone + "," + account.getUserName()+ ","+account.getEncryptedPassword();
    }


    public void persist() throws IOException{

    }
}
