package com.revature.services;

import com.revature.daos.employee_dao;
import com.revature.models.Employee;

import java.util.List;

public class Employee_Services {

    public employee_dao EMP_DAO = new employee_dao();

    public List<Employee> allEmployees(){
        return EMP_DAO.getAllEmployees();
    }

    public Employee getEmployee(int ID){
        return EMP_DAO.getEmployeeByID(ID);
    }

    public boolean newEmployee(Employee employee){
        return EMP_DAO.add_Employee(employee);
    }

    
    
}
