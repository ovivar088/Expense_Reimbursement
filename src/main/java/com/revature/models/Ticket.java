package com.revature.models;

public class Ticket {
    int id;
    String employee;
    String memo;
    float amount; 
    String status;
    //Declare the fields of a ticket
    public Ticket(int id, String employee, String memo, float amount) {
        this.id = id;
        this.employee = employee;
        this.memo = memo;
        this.amount = amount;
        this.status = "pending";
    }

    /*==========================Getters and Setters============================*/
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
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

    
    

    

    
}
