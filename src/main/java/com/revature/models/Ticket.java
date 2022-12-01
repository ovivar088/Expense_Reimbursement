package com.revature.models;

public class Ticket {
    int ticket_ID;
    int employee_id;
    String first_name;
    String last_name;
    String memo;
    float amount; 
    String status;
    //Declare the fields of a ticket
    public Ticket(int employee_id, String first_name, String last_name, float amount, String memo) {
        this.ticket_ID = ticket_ID + 1; //REVIEW Q4T
        this.employee_id = employee_id;
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
