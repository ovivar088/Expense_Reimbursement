package com.revature.services;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.revature.services.Employee_Services;


public class Login_Services {

    //private static Logger log = LoggerFactory.getLogger(Login_Services.class);
    
    public boolean login(String username, String password){

        //log.info("User attempted to login with username: " + username);

        try{
            //To login we need to see that user exists and pass word is also correct

            Employee_Services employee_service = new Employee_Services();
            boolean exists = employee_service.validate_credentials(username, password);
            //We need to invoke a Employee_DAO method which will see if said username exists

            if(exists){
                //log.info(username + " logged in.");
                return true;
            }
            //log.warn("============Invalid credentials, (username, password) "+ username + " " + password + "===========");
            return false;

            //This is where things will change. however for simplicity sake we will continue with a hardcoded login
            /* 
            if(username.equals("BOSSMAN") && password.equals("MegaAdmin")){
                log.info(username + " logged in.");
                return true;
            }
            log.warn(username+" failed to logged in.");
			return false;
            */

        }
        catch(NullPointerException e){
            //log.warn(username + " attempted to login with null value");
            return false;
        }
    }






}
