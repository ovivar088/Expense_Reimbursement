package com.revature.controllers;
//Controller will Handle HTTP

import com.revature.daos.employee_dao;
import com.revature.models.Employee;


import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;



public class Employee_Controller {
    
    //We will bypass the "services" for now
    public employee_dao employee_data = new employee_dao();
    

    private Handler getAllEmployees = (ctx) -> {
        List<Employee> list = employee_data.getAllEmployees();
        
        ctx.json(list);
        ctx.status(200);
    }; //This is basically a java script arrow function, we are putting a request

    private Handler addEmployee = (ctx) -> {
        Employee emp = ctx.bodyAsClass(Employee.class);
        employee_data.add_Employee_2(emp); //gotta fix this
        ctx.status(201);
    };

    //@Override //not neccesarry rn because we are not overriding
    public void addRoutes(Javalin app){
        /*app.get("/employee", (ctx) ->{
            ctx.html("<h1>Employee Homebase</h1>");
            ctx.status(200);
        });
        */
        app.get("/employee", getAllEmployees); //there is a problem here for sure
        app.post("/employee", addEmployee);
    }
}

