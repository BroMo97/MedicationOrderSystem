/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MedicationOrderSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author OENAL
 */
public class Customer {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private String birthday;
    private String street;
    private String zip;
    private String city;
    private String gender;
    private String phone;
    private boolean deleted;

    public Customer(String username, String password, String firstname, String lastname, String mail, String birthday, String street, String zip, String city, String gender, String phone, boolean deleted) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.birthday = birthday;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.gender = gender;
        this.phone = phone;
        this.deleted = deleted;
    }

    Customer() {
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public boolean register(){
        DBConnection con = new DBConnection();
        
        String query = "INSERT INTO customer (username, password, firstname, lastname, mail, birthday, street, " +
                "zip, city, gender, phone, deleted)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,0);";
        
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, mail);
            ps.setString(6, birthday);
            ps.setString(7, street);
            ps.setString(8, zip);
            ps.setString(9, city);
            ps.setString(10, gender);
            ps.setString(11, phone);
            
            ps.execute();
            return true;
        } catch (SQLException e){
            return false;
        }
    }
    
    public boolean login(){
        return true;
    }
}
