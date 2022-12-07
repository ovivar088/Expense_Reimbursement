package com.revature.controllers;

import com.revature.services.Ticket_Services;
import com.revature.services.Employee_Services;

import com.revature.models.Ticket;
import com.revature.models.Login_DTO;

import com.revature.exceptions.*;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import jakarta.servlet.http.HttpSession;

public class Ticket_Controller {
    
    private Ticket_Services ticket_service = new Ticket_Services();
    private Employee_Services employee_service = new Employee_Services();

    //Here is also where we will manage all the Handlers, very scary terry.


    //Change to get All tickets by ID
    Handler getUsersTickets = (ctx) -> {

        //Somewhere needs to be provided an ID
        HttpSession session = ctx.req().getSession(false); 
        //session should be active, we need to be able to pass the logins and shit
        Login_DTO user = (Login_DTO) session.getAttribute("user"); //Who is the user
        
        String username = user.username;
        //boolean isManager = employee_service.getManagerStatus(username);


        //Need to have two conditions:
        //User can see only his own tickets
        //Manager can see everyones tickets
        if(session != null){
            ctx.json(ticket_service.allEmployeesTickets(username));
            ctx.status(200);
        }
        else{
            ctx.status(400);
        }
    };
    
    Handler pendingTicketsbyUsername = (ctx) -> {

        HttpSession session = ctx.req().getSession(false);

        Login_DTO user = (Login_DTO) session.getAttribute("user");
        String username = user.username;

        if(session != null){
            System.out.println("Trying to get pending tickets by username");
            ctx.json(ticket_service.pendingTicketsbyUsername(username));
            ctx.status(201);
        }
        else{
            ctx.status(400);
        }
    };
    
    //YES
    Handler newTicket = (ctx) -> {
        Ticket new_ticket = ctx.bodyAsClass(Ticket.class);

        if(ticket_service.new_ticket(new_ticket)){
            ctx.status(200);
        }
        else{
            ctx.status(400);
        }
    };

    Handler changeStatus = (ctx) -> {
        Ticket ticket = ctx.bodyAsClass(Ticket.class);
        String new_status = ticket.status; //We have the new status of our ticket
        String user = ticket.username;
        int ticket_id = ticket.ticket_ID;
        System.out.println("============Changing Status passing class========= Fields:=======");
        System.out.println("Status = "+ new_status + " User = "+ user + "ticked_ID = "+ ticket_id);

        boolean updated = ticket_service.update_status(new_status, ticket_id, user);
        if(updated){
            System.out.println("=============Updated ticket status===============");
            ctx.status(200);
        }
        else{
            ctx.status(500);
        }
        /*
        try{
            if(updated){
                System.out.println("=============Updated ticket status===============");
                ctx.status(200);
            }
            else{
                ctx.status(500);
            }
        }
        catch(ChangeStatusException e){
            ctx.status(400);
        }
        */
    };

    Handler allPending = (ctx) -> {
        HttpSession session = ctx.req().getSession(false);

        if(session != null){
            System.out.println("Trying to get all pending tickets");
            ctx.json(ticket_service.allPendingTickets());
            ctx.status(201);
        }
        else{
            ctx.status(400);
        }
    };

    public void addRoutes(Javalin app){

        app.get("/employee/{username}/tickets", getUsersTickets);

        app.get("/employee/{username}/pending", pendingTicketsbyUsername);

        app.post("/employee/{username}", newTicket);

        app.patch("/employee/{username}/pending", changeStatus);

        app.get("employee/pending/all", allPending);

        

    }




}

