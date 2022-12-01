package com.revature.daos;
//Models Connection to DB (my stuff)
import com.revature.models.Employee;
import com.revature.utils.DB_Conncection;
//SQL Dependencies ---- JDBC Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Structures to hold Data
import java.util.List;
import java.util.ArrayList;

public class employee_dao {
   
    //Get all Employees
    public List<Employee> getAllEmployees(){

        try(Connection connection = DB_Conncection.getConnection()){
            //If a connection is Established get All Employees from DB
            String sql = "SELECT * FROM Employees;"; //Our table will be Employees

            Statement statement = connection.createStatement(); //Telling java we are giving it an SQL statement, not no regular statement

            ResultSet Query_Result = statement.executeQuery(sql); //The sequel query will be returned here

            List<Employee> Employees = new ArrayList<>(); //Make an array list to keep the results

            //Populate the Employee List "EMPLOYEES" with Data from DB
            while(Query_Result.next()){
                Employee employee = new Employee();
                employee.setEmployee_id(Query_Result.getInt("Employee_ID"));
                employee.setFirst_name(Query_Result.getString("First_Name"));
                employee.setLast_name(Query_Result.getString("Last_Name"));
                employee.setEmail(Query_Result.getString("Email"));;
                employee.setUsername(Query_Result.getString("Username"));
                employee.setPassword(Query_Result.getString("Password"));

                Employees.add(employee); //Add the employee to the ArrayList
            }
            return Employees;
        } //try to establish a connection to Database first
        catch(SQLException e) {
            System.out.println("========================ERROR Establishing Connection to DB===================================");
            e.printStackTrace();
            System.out.println("==========================STACK TRACE ^^^^^============================================");
            return null;
        }
    }

    //ADD EMPLOYEE to the DB
    public boolean add_Employee(Employee new_emp){ //lets see if this works better
        //Assure a connection is established...
        try(Connection connection = DB_Conncection.getConnection()){

            String sql = "INSERT INTO Employees (Employee_ID, First_Name, Last_Name, Email, Username, Password) VALUES(?,?,?,?,?,?);"; //QUESTION 4 TIM

            PreparedStatement statement = connection.prepareStatement(sql);

            int index = 0;
            statement.setInt(++index, new_emp.getEmployee_id()); //this should be an integer no because it is an ID,  QUESTION 4 TIM
            statement.setString(++index, new_emp.getFirst_name());
            statement.setString(++index, new_emp.getLast_name());
            statement.setString(++index, new_emp.getEmail());
            statement.setString(++index, new_emp.getUsername());
            statement.setString(++index, new_emp.getPassword());

            statement.execute(); 
            return true;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //GET EMPLOYEE BY NAME
    public Employee getEmployeeByID(int ID){ //FIX THIS HERE MY BOI

        try (Connection connection = DB_Conncection.getConnection()){

            String sql = "SELECT * FROM Employees WHERE Employee_ID = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, ID); //What is the 1??? is it a row number?

            ResultSet Query_Result = statement.executeQuery();

            Employee employee = new Employee();

            if(Query_Result.next()){

                employee.setEmployee_id(Query_Result.getInt("Employee_ID"));
                employee.setFirst_name(Query_Result.getString("First_Name"));
                employee.setLast_name(Query_Result.getString("Last_Name"));
                employee.setEmail(Query_Result.getString("Email"));;
                employee.setUsername(Query_Result.getString("Username"));
                employee.setPassword(Query_Result.getString("Password")); //In this case
            }
            return employee;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    //DELETE EMPLOYEE

    //UPDATE EMPLOYEE




    /* 
    //OLD DAO FOR HTTP REQEUSTING W/O DB

    //private static List<Employee> employee_list= new ArrayList<>();

    public employee_dao(){        
        System.out.println("======================Employee DAO initialized============================");
        employee_list.add(new Employee(1, "Osi", "Vert", "osivert@gmail.com", "osivert117", "vertical21!"));
        System.out.println("================We succesfully added=======================" + employee_list.get(0).last_name);
    }
    */

    //Add Employee, we need to pass the fields for our employee but we should do this in the employee field 
    /*
    public void add_Employee(int employee_id, String first_name, String last_name, String email, String username, String password){
        Employee new_emp = new Employee(employee_id, first_name, last_name, email, username, password);
        employee_list.add(new_emp);
    }
    */

    







}
