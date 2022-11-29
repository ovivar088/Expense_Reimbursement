package com.revature.daos;

import com.revature.models.Ticket;

import java.util.List;
import java.util.ArrayList;


public class ticket_dao {
    
    private static List <Ticket> ticket_list = new ArrayList<>(); //make a list of tickets

    //no args constructor
    public ticket_dao() {
        super();
    }

    public List<Ticket> getAllTickets(){
        return ticket_list;
    }

    public void add_ticket(Ticket ticket){
        ticket_list.add(ticket);
    }
}
