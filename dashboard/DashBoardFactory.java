package com.epa.dashboard;

public class DashBoardFactory {

    public static Dashboard getDashboard(String role){
        if("EMPLOYEE".equals(role)){
            return new EmployeeDashBoard();
        }else if("MANAGER".equals(role)){
            return new ManagerDashBoard();
        }
        return null;
    }
}
