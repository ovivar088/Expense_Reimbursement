package com.revature.models;

//import com.revature.daos.ticket_dao;

public class Manager {

    //fields of a Manager, also should have an ID probably
    int employee_id;
    String first_name;
    String last_name;
    String email;
    String username;
    String password;
    boolean is_manager;


    public Manager(int employee_id, String first_name, String last_name, String email, String username, String password,
            boolean is_manager) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.is_manager = is_manager;
    }

    //Needs a function which can call

    //The manager needs special access to the ticket bin
    

    
}
