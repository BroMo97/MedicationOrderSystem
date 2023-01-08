package MedicationOrderSystem.Handler;


import MedicationOrderSystem.Classes.*;
import java.sql.*;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DatabaseHandler {

    private static Connection con;
    
    public DatabaseHandler() {
        con = getConnection();
    }

    public static Connection getConnection(){
        final String USERNAME = "Admin";
        final String PASSWORD = "admin";
        String URL = "jdbc:mysql://localhost:3306/apotheke_progex=convertToNull&serverTimezone=Europe/Berlin";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * creates a new user within the database
     * @param User user which will be created
     * @param password encrypted
     */
    public void createNewUser(User User, String password) {
        String setuser = "INSERT INTO user( u_username, u_email, u_password, u_firstName, u_lastName) VALUES (?,?,?,?,?)";
        try ( PreparedStatement st = con.prepareStatement(setuser)) {
            st.setString(1, User.getFirstname());
            st.setString(2, User.getLastname());
            st.setString(3, User.getBirthday();
            st.setString(4, User.getAddress());
            st.setString(5, password);
            st.setString(6, "0");
            st.setString(7, User.getUsername());
            st.setString(8, User.getGender());
            st.setString(9, User.getRole());
            st.setString(10, User.getEmail());
            st.setString(11, User.getPhone());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.out.println("Insert new User Successfull");

    }

     /**
     * Checks whether an User exists with the entered username and password 
     * @param username 
     * @param password encrypted password
     * @return {@link User} if the user exists, else null
     */
    public User checkifUserExists(String username, String password) {
        User user = null;
        String sql = "Select * FROM user where u_username = ? AND u_password = ? AND  U_DELETED = 0 ";

        try ( PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    user = getUser(rs);
                }

            }
        } catch (SQLException ex) {
            
        }
        return user;
    }
    
}
