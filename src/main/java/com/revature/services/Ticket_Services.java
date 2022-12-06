package com.revature.services;

import com.revature.daos.ticket_dao;
import com.revature.models.Ticket;

import java.util.List;

public class Ticket_Services {

    public ticket_dao ticket_DAO = new ticket_dao();

    //Manager Function
    public List<Ticket> getallTickets(){ //NOW THAT I THINK ABOUT IT ERRR
        return ticket_DAO.getAllTickets();
    }

    //Manager and Employee Function, Except employee will pass his ID auto.
    public Ticket getTicketbyEmployeeID(int ID){
        return ticket_DAO.getTicketByID(ID);
    }
    //Manager and Employee Function, Except employee will pass his ID auto
    public List<Ticket> pendingTicketsbyEmployeeID(int ID){
        return ticket_DAO.getPendingTickets(ID);
    }
    //Manager and Employee Function, Managers cannot approve their own
    public boolean new_ticket(Ticket ticket){
        return ticket_DAO.add_ticket(ticket);
    }
    //Employee and Manager
    //Can only remove a ticket with status == pending
    //Can only remove your own ticket, not even admins can remove an employees.
    public boolean remove_ticket(int Ticket_ID, int Employee_ID){
        return ticket_DAO.delete_ticket(Ticket_ID, Employee_ID);
    }
    //
    public boolean update_status(String new_Status, int Ticket_ID, int Employee_ID){
        return update_status(new_Status, Ticket_ID, Employee_ID);
    }

}
