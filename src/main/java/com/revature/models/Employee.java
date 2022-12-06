package com.revature.models;

import com.revature.models.Ticket;

public class Employee {
    //All this stuff needs to be received from the Front End!
    public int employee_id;
    public String first_name; 
    public String last_name;
    public String email;
    public String username;
    public String password;
    public boolean ismanager;
    //int emplyee_id; //also doable but probablly not necessary
    public Employee(int employee_id, String first_name, String last_name, String email, String username, String password, boolean ismanager) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.ismanager = ismanager;
    }
    public Employee(){
        super();
    };

    public int getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getIsManager() {
        return ismanager;
    }
    public void setIsManager(boolean ismanager) {
        this.ismanager = ismanager;
    }
    

    //Method to create a new ticket
    /* 
    public Ticket create_ticket(float amount, String memo){
        //Only input the amount and the memo, the rest of the fields will be passed by the 


        Ticket new_ticket = new Ticket(this.employee_id, this.first_name, this.last_name, amount, memo); //This is different the function wi
        //This new ticket needs to not only be 
        return(new_ticket);
    }
    */




    //we will have a log --> data object which holds ALL outstanding tickets
    
}
