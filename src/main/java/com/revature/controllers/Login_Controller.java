package com.revature.controllers;

import com.revature.services.Login_Services;
import com.revature.models.Login_DTO;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import jakarta.servlet.http.HttpSession;

public class Login_Controller {
    
    private Login_Services login_service = new Login_Services();
    
    Handler login = (ctx) -> {
        
        Login_DTO attempt = ctx.bodyAsClass(Login_DTO.class);
        //Input output, in the ctx of the response will be information that will receieve a class
        //The class type is Login_DTO

        if (login_service.login(attempt.username, attempt.password)){

            HttpSession session = ctx.req().getSession();
            session.setAttribute("user", attempt); //user of the session is "attempt"
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
            ctx.status(400); 
        }

    };

    public void addRoutes(Javalin app){
        app.post("/login", login);
        app.get("/logout", logout);
    }

}
