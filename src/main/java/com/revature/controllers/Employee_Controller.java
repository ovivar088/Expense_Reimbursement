package com.revature.controllers;
//Controller will Handle HTTP

import com.revature.services.Employee_Services;
import com.revature.models.Employee;


import io.javalin.Javalin;
import io.javalin.http.Handler;


public class Employee_Controller {
    
    //We will bypass the "services" for now
    private Employee_Services employee_service = new Employee_Services();
    

    Handler getAllEmployees = (ctx) -> {
        ctx.json(employee_service.allEmployees()); //allEmployes to get array list of all employees
        ctx.status(200);
        //Function returns nothing I guess, will just display json object...
    }; 

    Handler addEmployee = (ctx) -> {
        Employee emp = ctx.bodyAsClass(Employee.class); //Q4 TIMMMMM
        //I AM PARSING BODY AS CLASS
        if(employee_service.newEmployee(emp)){ //if add employee is successful it will return true.
            ctx.status(201);
        }
        else{
            ctx.status(400);
        }
    };

    Handler getEmployee = (ctx) -> {
        String ID_string = ctx.pathParam("Employee_ID");  
        int ID;
        try{
            ID = Integer.parseInt(ID_string);
        }
        catch(NumberFormatException e){ //there aint no sql excepion here, would be number format exception
            ctx.status(422);
            return;
        }

        Employee employee = employee_service.getEmployee(ID);
        ctx.json(employee); //if i remove this for some reason i get an issue for catch block
        ctx.status(200);
    };


    //@Override //not neccesarry rn because we are not overriding
    public void addRoutes(Javalin app){
        /*app.get("/employee", (ctx) ->{
            ctx.html("<h1>Employee Homebase</h1>");
            ctx.status(200);
        });
        */
        app.get("/employee", getAllEmployees); //there is a problem here for sure
        app.get("/employee/{ID}", getEmployee); //Q4T
        app.post("/employee", addEmployee);
    }
}

