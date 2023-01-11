package MedicationOrderSystem.Classes;
import java.time.LocalDateTime;

import MedicationOrderSystem.Handler.*;
import ENUMs.*;
/**
 * Class which monitors and maintains the data of users of the project
 * @author patricia
 */


public class User {
    private String name = null;
    private String surname = null;
    private String username = null;
    private String email = null;
//    private int role = 0;
// ---- hier bitte getter setter einfügen und in Constructor hinzufügen ----     
    private Gender gender = null; 
    private String address = null; 
    private LocalDateTime birthday = null;
    private String phone = null;
    private Rank userRank;
    
    
    //Constructor
    public User(String name, String surname, String username, String email, Gender gender, String address,LocalDateTime birthday,String phone, Rank _userRank ) 
    {
        this.setFirstname(name);
        this.setLastname(surname);
        this.setUsername(username);
        this.setEmail(email);
//        this.setRole(role); //LASS EIN ENUM VERWENDEN
        this.setGender(gender);
        this.setAddress(address);
        this.setBirthday(birthday);
        this.userRank = _userRank;
        // this.setPassword(password);
    }

    public String getFirstname() {
        return name;
    }

    public String getLastname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    //public String getPassword() {return password;}

    public void setFirstname(String _firstname) {
        name = _firstname;
    }

    public void setLastname(String _lastname) {
        surname = _lastname;
    }

    public void setUsername(String _username) {
        username = _username;
    }

    public void setEmail(String _email) {
        email = _email;
    }
    //public void setPassword(String _password) {password=_password;}

//    public String getRoleName() {
//        if (this.role) {
//            return "Admin";
//        }
//        return "User";
//    }

//    public int getRole() {
//        return role;
//    }

//    public void setRole(int _role) {
//        role = _role;
//    }

    public Gender getGender (){
        return gender;
    }

    public void setGender(Gender _gender){
        gender = _gender; 
    }

    public String getAddress (){
        return address;
    }

    public void setAddress(String _address){
        address = _address; 
    }

    public void setPhone(String _phone){
        phone = _phone; 
    }

    public String getPhone (){
        return phone;
    }

    public LocalDateTime getBirthday() {
        if (birthday != null) {
            return this.birthday;
        }
        return LocalDateTime.MAX;
        }
        
        public void setBirthday(LocalDateTime _birthday) {
        birthday = _birthday;
        }

    @Override
    public String toString() {
        return this.getFirstname() + " "
                + this.getLastname();
                
    }

    public Rank getUserRank() {
        return userRank;
    }

    public void setUserRank(Rank userRank) {
        this.userRank = userRank;
    }
    
    
    
    @Override
    public boolean equals(Object other) { 
  
        // If the object is compared with itself then return true   
        /* Check if other is an instance of User or not 
          "null instanceof [User]" also returns false */
        if (!(other instanceof User)) { 
            return false; 
        } 
          
        // Compare the usernames and return accordingly 
        return this.username.equals(((User) other).username);
    } 
    
}
