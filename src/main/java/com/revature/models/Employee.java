package com.revature.models;

//import com.revature.models.Ticket;

public class Employee {
    //All this stuff needs to be received from the Front End!
    public int employee_id;
    public String first_name; 
    public String last_name;
    public String email;
    public String username;
    public String password;
    //int emplyee_id; //also doable but probablly not necessary
    public Employee(int employee_id, String first_name, String last_name, String email, String username, String password) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Employee(){
        super();
    };
    
    //Method to create a new ticket
    public Ticket create_ticket(int id, String employee, String memo, float amount){ //if we are to create a ticket we need the fields of consructor
        Ticket new_ticket = new Ticket(id, employee, memo, amount);
        
        //This new ticket needs to not only be 

        return(new_ticket);
    }





    //we will have a log --> data object which holds ALL outstanding tickets
    
}
