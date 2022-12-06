package com.revature.controllers;

import com.revature.services.Ticket_Services;
import com.revature.models.Ticket;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Ticket_Controller {
    
    private Ticket_Services ticket_service = new Ticket_Services();

    //Here is also where we will manage all the Handlers, very scary terry.

    Handler getAllTickets = (ctx) -> {
        ctx.json(ticket_service.getallTickets()); //Returns in json format an array list
        ctx.status(200);
    };
    
    Handler getTicketbyEmployeeID = (ctx) -> {

        

    };
    

    Handler newTicket = (ctx) -> {
        Ticket new_ticket = ctx.bodyAsClass(Ticket.class);

        if(ticket_service.new_ticket(new_ticket)){
            ctx.status(200);
        }
        else{
            ctx.status(400);
        }
    };

}

