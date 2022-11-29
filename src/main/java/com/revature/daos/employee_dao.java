package com.revature.daos;

import com.revature.models.Employee;

import java.util.List;
import java.util.ArrayList;

public class employee_dao {
    private static List<Employee> employee_list= new ArrayList<>();

    public employee_dao(){
        System.out.println("======================Employee DAO initialized============================");
        employee_list.add(new Employee(1, "Osi", "Vert", "osivert@gmail.com", "osivert117", "vertical21!"));
        System.out.println("================We succesfully added=======================" + employee_list.get(0).last_name);
    }

    //Get all Employees
    public List<Employee> getAllEmployees(){
        return employee_list;
    }    
    
    public void add_Employee_2(Employee new_emp){ //lets see if this works better
        employee_list.add(new_emp);
    }


    //Add Employee, we need to pass the fields for our employee but we should do this in the employee field 
    /*
    public void add_Employee(int employee_id, String first_name, String last_name, String email, String username, String password){
        Employee new_emp = new Employee(employee_id, first_name, last_name, email, username, password);
        employee_list.add(new_emp);
    }
    */

    







}
