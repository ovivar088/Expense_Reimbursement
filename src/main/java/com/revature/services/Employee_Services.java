package com.revature.services;

import com.revature.daos.employee_dao;
import com.revature.models.Employee;

import java.util.List;

public class Employee_Services {

    public employee_dao EMP_DAO = new employee_dao();

    public List<Employee> allEmployees(){
        return EMP_DAO.getAllEmployees();
    }

    public Employee getEmployeebyUsername(String username){
        return EMP_DAO.getEmployeeByUsername(username);
    }

    public boolean newEmployee(Employee employee){
        return EMP_DAO.add_Employee(employee);
    }
    
    public boolean getManagerStatus(String username){
        return EMP_DAO.getManagerStatus(username);
    }

    public boolean validate_credentials(String username, String password){
        return EMP_DAO.valid_credentials(username, password);
    }

    public boolean user_exists(String username, String email){
        return EMP_DAO.username_exists(username, email);
    }
    
    
}
