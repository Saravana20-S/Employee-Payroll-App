package com.epa.dashboard;

import com.epa.empRegistration.Employee;
import com.epa.payrollGen.Payslip;


import java.util.*;

public class EmployeeDashBoard implements Dashboard {

    public void display(ArrayList payslips, Employee employee){
        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, "+ employee.getName());

        Collections.sort(payslips, new Comparator() {
            public int compare(Object o1, Object o2){
                Payslip p1 = (Payslip) o1;
                Payslip p2 = (Payslip) o2;
                return (int)(p2.getNetPay()-p1.getNetPay());
            }
        });


        System.out.println("\nRecent Payslips (Top 3):");
        int count =0;
        Iterator it = payslips.iterator();
        while(it.hasNext() && count <3){
            Payslip p = (Payslip) it.next();
            System.out.println(p);
            count++;
        }

        double total =0;
        Iterator it2 = payslips.iterator();
        while(it2.hasNext()){
            Payslip p = (Payslip) it2.next();
            total += p.getNetPay();
        }


        System.out.println("\nYear-To-Earnings: "+total);


    }
}
