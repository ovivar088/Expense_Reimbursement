package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Conncection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection!=null && !connection.isClosed())
        {
            return connection;
        }
        else
        {
            //For many frameworks or in case of using Multiple SQL drivers
            //the application will need to register the active driver class
            //The class.forName method can do this. Generally with small projects
            //and the raw JDBC this is not necessary, but its good practice

            try{ //SQL exception is CHECKED exception, DB may not exist so we need to make sure it exists.
                Class.forName("org.postgresql.Driver"); //find this in dependencies i believe
            }
            catch(ClassNotFoundException e){ //if it does not exist then we will just return null and print the stack trace of what occurred.
                System.out.println("=====================STACK TRACE=======================");
                e.printStackTrace();
                System.out.println("=====================STACK TRACE ^^^^^^^^^^=================");
                return null;
            }

            String url = "jdbc:postgresql://localhost:5433/Revature_Project_1"; //might want to change
            String username = "postgres"; //Raw credentials like this are not secure
            String password = "password"; //If accessing a remote DB, preferable to use env variables or config files for credentials to obscure them
        
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        }

    }
    public static void main(String[] args) {
        		try {
        			getConnection();
        			System.out.println("Connection successful");
        		} catch (SQLException e) {
        			e.printStackTrace();
                    System.out.println("WTF");
        		}
        	}

}
