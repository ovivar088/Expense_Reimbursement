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
    
    //no args constructor
    public ticket_dao() {
        super();
    }

    //GET ALL TICKETS for Employees
    public List<Ticket> allEmployeesTickets(String username){
        
        try(Connection connection = DB_Conncection.getConnection()){
            String sql = "SELECT * FROM Tickets WHERE username = " + "'"+username+"';"; //Select all tickets

            System.out.println("======================SQL STATEMENT=====================");
            System.out.println(sql);

            Statement statement = connection.createStatement();

            ResultSet query_Result = statement.executeQuery(sql);

            List<Ticket> Tickets = new ArrayList<>();

            //Populate the Ticket list "TICKETS"
            while(query_Result.next()){ //Transforming query result into appropriate objects
                Ticket ticket = new Ticket();
                ticket.setTicket_ID(query_Result.getInt("Ticket_ID"));
                ticket.setUsername(query_Result.getString("Username"));
                ticket.setFirst_name(query_Result.getString("First_Name"));
                ticket.setLast_name(query_Result.getString("Last_Name"));
                ticket.setAmount(query_Result.getFloat("Amount"));
                ticket.setMemo(query_Result.getString("Memo"));

                Tickets.add(ticket);
            }
            return Tickets;
        }
        catch(SQLException e) {
            System.out.println("========================ERROR GETTING TICKETS BY USER===================================");
            e.printStackTrace();
            System.out.println("==========================STACK TRACE ^^^^^============================================");
            return null;
        }
    }


    //Get All Pending tickets by username, if a non admin gets this we should
    public List<Ticket> getPendingTickets(String username){

        try(Connection connection = DB_Conncection.getConnection()){

            String sql = "SELECT * FROM Tickets WHERE username = "+"'"+username+"'"+" AND status = 'pending';"; //may or may not work
            System.out.println("========================SQL STATEMENT getPendingTickets=================");
            System.out.println(sql);


            Statement statement = connection.createStatement();
            //Prepared statement becayse we are asking for parameters

            ResultSet query_Result = statement.executeQuery(sql);

            //In this case I want to return a List of Tickets of tickets
            List<Ticket> Tickets = new ArrayList<>(); //Nice

            while(query_Result.next()){
                Ticket fresh_ticket = new Ticket();
                fresh_ticket.setTicket_ID(query_Result.getInt("Ticket_ID"));
                fresh_ticket.setUsername(query_Result.getString("Username"));
                fresh_ticket.setFirst_name(query_Result.getString("First_Name"));
                fresh_ticket.setLast_name(query_Result.getString("Last_Name"));
                fresh_ticket.setAmount(query_Result.getInt("Amount"));
                fresh_ticket.setMemo(query_Result.getString("Memo"));

                Tickets.add(fresh_ticket);
            }
            return Tickets;
        } 
        catch(SQLException e){
            System.out.println("==================Error Getting all pending tickets by ID==================");
            e.printStackTrace();
            System.out.println("=====================STACK TRACE ^^^====================");
            return null;
        }   

    }
    public List<Ticket> getAllPendingTickets(){

        try(Connection connection = DB_Conncection.getConnection()){

            String sql = "SELECT * FROM Tickets WHERE status = 'pending';"; //may or may not work
            System.out.println("========================SQL STATEMENT getPendingTickets=================");
            System.out.println(sql);


            Statement statement = connection.createStatement();
            //Prepared statement becayse we are asking for parameters

            ResultSet query_Result = statement.executeQuery(sql);

            //In this case I want to return a List of Tickets of tickets
            List<Ticket> Tickets = new ArrayList<>(); //Nice

            while(query_Result.next()){
                Ticket fresh_ticket = new Ticket();
                fresh_ticket.setTicket_ID(query_Result.getInt("Ticket_ID"));
                fresh_ticket.setUsername(query_Result.getString("Username"));
                fresh_ticket.setFirst_name(query_Result.getString("First_Name"));
                fresh_ticket.setLast_name(query_Result.getString("Last_Name"));
                fresh_ticket.setAmount(query_Result.getInt("Amount"));
                fresh_ticket.setMemo(query_Result.getString("Memo"));

                Tickets.add(fresh_ticket);
            }
            return Tickets;
        } 
        catch(SQLException e){
            System.out.println("==================Error Getting all pending tickets by ID==================");
            e.printStackTrace();
            System.out.println("=====================STACK TRACE ^^^====================");
            return null;
        }   

    }



    //When we add a ticket we want to add the ticket by ID
    //Ticket has field employee_id so lets leverage that
    public boolean add_ticket(Ticket new_ticket){
        
        try(Connection connection = DB_Conncection.getConnection()){

            String sql = "INSERT INTO Tickets (ticket_ID, Username, First_Name, Last_Name, Amount, Memo,status) VALUES(?,?,?,?,?,?,?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("=====================SQL PREPARED STATEMENT ADDING NEW TICKET ======================");
            System.out.println(sql);

            int index = 0; //Q4TIM --> is this just parameter insertion order??
            statement.setInt(++index, new_ticket.getTicket_ID());
            statement.setString(++index, new_ticket.getusername());
            statement.setString(++index, new_ticket.getFirst_name());
            statement.setString(++index, new_ticket.getLast_name());
            statement.setFloat(++index, new_ticket.getAmount());
            statement.setString(++index, new_ticket.getMemo());
            statement.setString(++index, new_ticket.getStatus());

            statement.execute();
            return true; //BOOLEAN
        }
        
        catch(SQLException e){
            System.out.println("=========ERROR ADDING TICKET TO DB===========");
            e.printStackTrace();
            System.out.println("===============STACK TRACE ^^^^================");
            return false;
        }
    }

        //Update ticket_status - MANAGER function, manager cannot do his own
    public boolean update_ticket_status(String Status, int Ticket_ID, String username){

        try(Connection connection = DB_Conncection.getConnection()){

            //We want to make sure that only ADMINS can use this, I think we handle that in control layer
            
            String sql = "UPDATE Tickets SET status = ? WHERE username = ? AND ticket_id = ?;"; //REVIEW STATEMENT

            PreparedStatement statement = connection.prepareStatement(sql);
            int index = 0;
            statement.setString(++index, Status);
            statement.setString(++index, username);
            statement.setInt(++index, Ticket_ID);

            statement.execute();
            return true;
        }
        catch(SQLException e){
            System.out.println("=========ERROR Updating Ticket Status===========");
            e.printStackTrace();
            System.out.println("===============STACK TRACE ^^^^================");
            return false;
        }

    }



    /*

    //Get Tickets by Employee_ID. Manager Funciton and Employee Function
    //Should work fine for a manager (maybe change for employee)
    public Ticket getTicketByID(int employee_id){

        try (Connection connection = DB_Conncection.getConnection()){

            String sql = "SELECT * FROM Tickets WHERE Employee_ID = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(0, employee_id); //What is the 1??? is it a row number?

            ResultSet query_Result = statement.executeQuery();

            Ticket ticket = new Ticket();

            if(query_Result.next()){
                ticket.setTicket_ID(query_Result.getInt("Ticket_ID"));
                ticket.setEmployee_id(query_Result.getInt("Employee_ID"));
                ticket.setFirst_name(query_Result.getString("First_Name"));
                ticket.setLast_name(query_Result.getString("Last_Name"));
                ticket.setAmount(query_Result.getInt("Amount"));
                ticket.setMemo(query_Result.getString("Memo")); //In this case
            }
            return ticket;
        }
        catch(SQLException e){
            System.out.println("=============Error Getting Ticket using Employee_ID through DB, ==================");
            e.printStackTrace();
            System.out.println("================STACK TRACE ^^^====================");
            return null;
        }
    }





    //Delete Ticket by ID and Employee_ID, but probably will only need Employee_ID field
    public boolean delete_ticket(int Ticket_ID, int Employee_ID){
        
        try(Connection connection = DB_Conncection.getConnection()){
            
            String sql = "DELETE FROM Tickets WHERE Employee_ID = ? AND Ticket_ID = ?;"; //REVIEW STATEMENT

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(0, Employee_ID);
            statement.setInt(1, Ticket_ID);

            statement.execute();
            return true;
        }
        catch(SQLException e){
            System.out.println("=========ERROR Deleting Ticket from DB using Employee and Ticket ID===========");
            e.printStackTrace();
            System.out.println("=================STACK TRACE ^^^^=====================");
            return false;
        }
    }
    */




    //Update ticket field
}
