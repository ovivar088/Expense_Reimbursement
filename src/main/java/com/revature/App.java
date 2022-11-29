package com.revature;

import com.revature.controllers.Employee_Controller;
import com.revature.models.Employee;

import io.javalin.Javalin;

public class App {
    
    private static Javalin app;

    public static void main(String[] args){

        app = Javalin.create(); //Configures how javalin will run

        // /hello
        app.get("hello", (ctx) -> {

            //Request information, not sure what this is contributing
            String url = ctx.url();
            System.out.println(url);

            //Set response info
            ctx.html("<h1>Javalin Testing...Or Something</h1>");
            ctx.status(200);
        });


        app.get("practice", (ctx) ->{

            ctx.html("<title>Practice Tab</title><h1>True</h1>");
            ctx.status(200);

        });


        configure(new Employee_Controller());
        app.start(8081);
        
    }
    /* 
    public static void configure(Employee_Controller... controllers){
        for(Employee_Controller c:controllers) {
            c.addRoutes(app); //for every Employee_controller in controllers add Route t
        }
    }
    */
    
    public static void configure(Employee_Controller controller){
        controller.addRoutes(app); //addRoutes is a function of Employee_Controller
    }



}
