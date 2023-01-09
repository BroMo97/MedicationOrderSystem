package MedicationOrderSystem.Handler;


import MedicationOrderSystem.Classes.*;

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
//    public void createNewUser(User User, String password) {
//        String setuser = "INSERT INTO user( name, surname, birthday, address, password, deleted, username, gender, role, mail, phone) VALUES (?,?,?,?,?)";
//        try ( PreparedStatement st = con.prepareStatement(setuser)) {
//            st.setString(1, User.getFirstname());
//            st.setString(2, User.getLastname());
//            st.setString(3, User.getBirthday();
//            st.setString(4, User.getAddress());
//            st.setString(5, password);
//            st.setString(6, "0");
//            st.setString(7, User.getUsername());
//            st.setString(8, User.getGender());
//            st.setString(9, User.getRole());
//            st.setString(10, User.getEmail());
//            st.setString(11, User.getPhone());
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(DatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        System.out.println("Insert new User Successfull");
//
//    }


     /**
     * Checks whether an User exists with the entered username and password 
     * @param username 
     * @param password encrypted password
     * @return {@link User} if the user exists, else null
     */
    public User checkifUserExists(String username, String password) {
        User user = null;
        String sql = "Select * FROM user where username = ? AND password = ? AND  DELETED = 0 ";

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
    
    /**
     * Checks whether an Email has already been taken
     * @param toBeChecked
     * @return true, if the Email is available, false else
     */
    public boolean UserEmailAvailable(Registration toBeChecked) {

        String sql = "Select  email FROM user WHERE email = ? AND deleted = 0;";
        try ( PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, toBeChecked.getEmail());
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

     /**
     * Checks whether a username has already been taken
     * @param toBeChecked
     * @return true, if username is available, false else
     */
    public boolean UserNameAvailable(Registration toBeChecked) {
        String sql = "Select username FROM user WHERE username =? AND deleted = 0;";
        try ( PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, toBeChecked.getUsername());
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    /**
     * Function to edit information of a {@link User}
     * @param user which will be edited
     */         
    public void EditUser(User user) {    
        String sql = "Update user SET email = ?, firstName = ?, lastName = ?, admin = ? WHERE username = ?";
        try { 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setBoolean(4, user.getRole());
            ps.setString(5, user.getUsername());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    /**
     * Edits the password of a user within the database
     * @param user the user who wants to change their password
     * @param newPassword the encrypted new password
     */
    public void EditPasswort(User user, String newPassword) {
        
        String updatepasswort = "Update user SET password = ? WHERE username = ?;";

        try ( PreparedStatement ps = con.prepareStatement(updatepasswort)) {
            
            ps.setString(1, newPassword);
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
         /**
     * fetches the Password of a {@link User} from the database
     * @param user 
     * @return encrypted password of a user 
     */
    public String getPassword(User user) {
        String getPassword = "SELECT password From User WHERE username = ?;";
        String password = "";
        try ( PreparedStatement ps = con.prepareStatement(getPassword)) {
            ps.setString(1, user.getUsername());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    password = rs.getString("password");
                }
            }
        } catch (SQLException e) {
            
        }
        return password;
    }

        /**
     * Returns an {@link User} Object by the username 
     * @param username of the logged in user
     * @return an User Object
     */
    public User getUserByUserName(String username) {
        String sql = "SELECT * FROM User WHERE username = ?;";
        try ( PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return getUser(rs);
                }
            }
        } catch (SQLException ex) {
            
        }
        return null;
    }

        /**
     * returns an {@link ArrayList} of all {@link User} which are stored in the 
     * database and are not deleted
     * @return list of all users
     */
    //get all user from the database for the admin interface 
    public ArrayList<User> getAllUser() {
        String sql = "SELECT * FROM User WHERE DELETED = 0";
        ArrayList<User> UserList = new ArrayList<>();
        try ( PreparedStatement st = con.prepareStatement(sql)) {
            try ( ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    User user = getUser(rs);
                    UserList.add(user);
                }
                return UserList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UserList;
    }

        /**
     * fetches the information of one dataset from the database 
     * and sets these information into an new {@link User} 
     * @param rs
     * @return an new User object
     * @throws SQLException 
     */
    // User String firstname, String lastname, String username, String email)
    // u_username, u_email, u_password, u_firstName, u_lastName, u_deleted, u_admin
    // name, surname, bithday, address, password, deleted, username, gender, role, mail, phone
    public User getUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString(1),
                rs.getString(2),
                rs.getString(7),
                rs.getString(10),
                rs.getBoolean(9)
        );

    }

        /**
     * The new updated information of an {@link User} who already exists 
     * get saved/ updated in the database
     * @param user 
     */
    //Admin Interface - User aktualisieren 
    public void UpdateUser(User user) {
        String sql = "Update user SET name = ? , surname = ?, mail = ?, role = ? WHERE username = ?;";
        try ( PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, user.getFirstname());
            st.setString(2, user.getLastname());
            st.setString(3, user.getEmail());
            st.setBoolean(4, user.getRole());
            st.setString(5, user.getUsername());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//        /**
//     * Deletes an {@link User}
//     * @param user which will be deleted
//     */
//    public void deleteUser(User user) {
//        String sql = "Update user SET deleted = 1  WHERE username = ?";
//        try ( PreparedStatement st = con.prepareStatement(sql)) {
//            st.setString(1, user.getUsername());
//            st.executeUpdate();
//
//            deleteUserinParticipants(user);
//            deleteEventsOfHost(user);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //delete everywhere where host and event 
//    }
}
