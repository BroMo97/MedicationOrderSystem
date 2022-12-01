package MedicationOrderSystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author OENAL
 */
public class DBConnection {
    private Connection con = null;
    
    DBConnection(){
        String url = "jdbc:mysql://localhost:3306/apotheke_progex";
        String user = "root";
        String password = "OneMio2022!";
        
        try{
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getCon(){
        return con;
    }
}