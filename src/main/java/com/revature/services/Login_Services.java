package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Login_Services {

    private static Logger log = LoggerFactory.getLogger(Login_Services.class);
    
    public boolean login(String username, String password){

        log.info("User attempted to login with username: " + username);

        try{
            //This is where things will change. however for simplicity sake we will continue with a hardcoded login
            if(username.equals("BOSSMAN") && password.equals("MegaAdmin")){
                log.info(username + " logged in.");
                return true;
            }
            log.warn(username+" failed to logged in.");
			return false;
        }
        catch(NullPointerException e){
            log.warn(username + " attempted to login with null value");
            return false;
        }

    }

}
