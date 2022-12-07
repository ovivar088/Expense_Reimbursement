package com.revature.services;

import com.revature.daos.ticket_dao;
import com.revature.exceptions.ChangeStatusException;
import com.revature.models.Ticket;

import java.util.List;

public class Ticket_Services {

    public ticket_dao ticket_DAO = new ticket_dao();

    //Manager Function and Employee function, okay
    
    public List<Ticket> allEmployeesTickets(String username){ //NOW THAT I THINK ABOUT IT ERRR
        return ticket_DAO.allEmployeesTickets(username);
    }

    //Manager and Employee Function, Except employee will pass his ID auto
    public List<Ticket> pendingTicketsbyUsername(String username){
        return ticket_DAO.getPendingTickets(username);
    }

    //Manager and Employee Function, Managers cannot approve their own
    public boolean new_ticket(Ticket ticket){
        return ticket_DAO.add_ticket(ticket);
    }

    public boolean update_status(String new_Status, int Ticket_ID, String username) throws ChangeStatusException{
        /*
        if(new_Status == null || new_Status == "Approved" || new_Status == "Denied"){
            throw new ChangeStatusException("User tried to change status of ticket"
            + "with status =  ");
        }
        */
        return ticket_DAO.update_ticket_status(new_Status, Ticket_ID, username);
    }

    public List<Ticket> allPendingTickets(){
        return ticket_DAO.getAllPendingTickets();
    }


    //Employee and Manager
    //Can only remove a ticket with status == pending
    //Can only remove your own ticket, not even admins can remove an employees.

    /* 
    public boolean remove_ticket(int Ticket_ID, int Employee_ID){
        return ticket_DAO.delete_ticket(Ticket_ID, Employee_ID);
    }
    */
    

}
