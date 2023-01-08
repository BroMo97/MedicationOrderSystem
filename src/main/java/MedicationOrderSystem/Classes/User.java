package MedicationOrderSystem.Classes;
import java.time.LocalDateTime;
import MedicationOrderSystem.Handler.*;

import MedicationOrderSystem.Handler.*;
/**
 * Class which monitors and maintains the data of users of the project
 * @author patricia
 */


public class User {
    private String name = null;
    private String surname = null;
    private String username = null;
    private String email = null;
    public enum Role{CUSTOMER, EMPLOYEE, ADMIN};
    private Role userRole = 0;
    
// ---- hier bitte getter setter einfügen und in Constructor hinzufügen ----     
    private String gender = null; 
    private String address = null; 
    private LocalDateTime birthday = null;
    private String phone = null;

    //Constructor
    public User(String name, String surname, String username, String email, enum role) {
        this.setFirstname(name);
        this.setLastname(surname);
        this.setUsername(username);
        this.setEmail(email);
        this.setRole(role);
        
        //    this.setPassword(password);
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

    public String getRoleName() {
        if (this.role) {
            return "Admin";
        }
        return "User";
    }

    public role getRole() {
        return role;
    }

    public void setRole(Enum _role) {
        role = _role;
    }

    @Override
    public String toString() {
        return this.getFirstname() + " "
                + this.getLastname();
                
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
