package com.revature.daos;
//Models and DB connection
import com.revature.models.Ticket;
import com.revature.utils.DB_Conncection; //WELL THIS IS EMBARASSING
//SQL DEPENDENCIES
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Structures to hold data
import java.util.List;
import java.util.ArrayList;



public class ticket_dao {
    
    private static List <Ticket> ticket_list = new ArrayList<>(); //make a list of tickets

    //no args constructor
    public ticket_dao() {
        super();
    }

    //GET ALL TICKETS --> Manager Function
    public List<Ticket> getAllTickets(){
        
        try(Connection connection = DB_Conncection.getConnection()){
            String sql = "SELECT * FROM Tickets;"; //Select all tickets

            Statement statement = connection.createStatement();

            ResultSet query_Result = statement.executeQuery(sql);

            List<Ticket> Tickets = new ArrayList<>();
        }
        
        return ticket_list;
    }

    public void add_ticket(Ticket ticket){
        ticket_list.add(ticket);
    }
}
