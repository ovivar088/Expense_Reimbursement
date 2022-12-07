package com.revature.controllers;

//import com.revature.models.Employee;
import com.revature.services.Login_Services;

//import com.revature.services.Employee_Services; //Importing so that we can get manager by ID
import com.revature.models.Login_DTO;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import jakarta.servlet.http.HttpSession;

public class Login_Controller {
    
    private Login_Services login_service = new Login_Services();
    
    Handler login = (ctx) -> {
        
        Login_DTO attempt = ctx.bodyAsClass(Login_DTO.class);

        if (login_service.login(attempt.username, attempt.password)){

            HttpSession session = ctx.req().getSession();
            session.setAttribute("user", attempt); //user of the session is "attempt"
            //Heres where we want to SET THE SESSION attribute manager status to true or false

            ctx.status(200);
        }
        else{
            ctx.status(HttpStatus.UNAUTHORIZED);
        }
    };

    Handler logout = (ctx) -> {
        HttpSession session = ctx.req().getSession(false);
        if(session!= null){
            session.invalidate(); //invalidating the entire session to logout.. pretty cool.
            ctx.status(200);
        }
        else{
            System.out.println("==========================LOG OUT ERROR=============================");
            ctx.status(400); 
        }

    };

    public void addRoutes(Javalin app){
        app.post("/login", login);
        app.get("/logout", logout);
    }



}
