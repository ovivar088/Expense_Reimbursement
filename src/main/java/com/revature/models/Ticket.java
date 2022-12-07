package com.revature.models;

public class Ticket {
    public int ticket_ID;
    public String username;
    public String first_name;
    public String last_name;
    public String memo;
    public float amount; 
    public String status;
    //Declare the fields of a ticket
    public Ticket(int ticket_ID, String username, String first_name, String last_name, float amount, String memo) {
        this.ticket_ID = ticket_ID; //REVIEW Q4T
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.memo = memo;
        this.amount = amount;
        this.status = "pending";
    }

    public Ticket(){
        super();
    }




    //======================SETTERS AND GETTERS=================
    public int getTicket_ID() {
        return ticket_ID;
    }

    public void setTicket_ID(int ticket_ID) {
        this.ticket_ID = ticket_ID;
    }
    
    public String getusername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*==========================Getters and Setters============================*/
    

    
    

    

    
}
