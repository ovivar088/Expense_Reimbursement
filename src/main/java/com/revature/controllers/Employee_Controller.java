package com.revature.controllers;
//Controller will Handle HTTP

import com.revature.services.Employee_Services;
import com.revature.models.Employee;
import com.revature.models.Login_DTO;


import io.javalin.Javalin;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

public class Employee_Controller {
    


    //We will bypass the "services" for now
    private Employee_Services employee_service = new Employee_Services();
    
    //ACCESSIBLE ONLY TO THE PEOPLE WHO HAVE ALREADY LOCKED IN, NEED A COOKIE HERE passed by login


    Handler getAllEmployees = (ctx) -> {

        HttpSession session = ctx.req().getSession(false); //if session does not exist, false --> do not create one

        Login_DTO user = (Login_DTO) session.getAttribute("user");
        String username = user.username;

        //We now have the username... use Employee Service
        boolean isManager = employee_service.getManagerStatus(username);
        System.out.println("=====================IS MANAGER == " + isManager + "======================");
        if(session != null){
            System.out.println("===============SESSION != NULL ===============================");
            if(isManager == true){
                ctx.json(employee_service.allEmployees()); //allEmployes to get array list of all employees
                ctx.status(200);
            }
            else{
                ctx.status(400);
            }
        }
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

    Handler getEmployeebyUsername = (ctx) -> {
        String username = ctx.pathParam("Employee_ID");  
        /*
        int ID;
        try{
            ID = Integer.parseInt(ID_string);
        }
        catch(NumberFormatException e){ //there aint no sql excepion here, would be number format exception
            ctx.status(422);
            return;
        }
        */

        Employee employee = employee_service.getEmployeebyUsername(username);
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

        //Manager only Function, Check credential...
        app.get("/employee", getAllEmployees); //there is a problem here for sure
        

        //Need to change this, probably will change it to be by name instead of ID
        app.get("/employee/{username}", getEmployeebyUsername); //FIX THIS!!!!!!!!!!!!!!!!!!!!!!!!!
        
        
        //Should be a Register End Point
        app.post("/register", addEmployee);

    }
}

