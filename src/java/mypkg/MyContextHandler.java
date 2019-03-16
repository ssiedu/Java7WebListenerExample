/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import javax.servlet.ServletContext;

public class MyContextHandler implements ServletContextListener {

    Connection con;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initilized Called");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
            ServletContext context=sce.getServletContext();
            context.setAttribute("data", con);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed Called");
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
