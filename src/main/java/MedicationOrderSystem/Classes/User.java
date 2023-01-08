package MedicationOrderSystem.Classes;
import MedicationOrderSystem.Handler.*;
/**
 * Class which monitors and maintains the data of users of the project
 * @author patricia
 */


public class User {
    private String firstname = null;
    private String lastname = null;
    private String username = null;
    private String email = null;
    private boolean role = false;

    //Constructor
    public User(String firstname, String lastname, String username, String email, boolean role) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setUsername(username);
        this.setEmail(email);
        this.setRole(role);
        //    this.setPassword(password);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    //public String getPassword() {return password;}

    public void setFirstname(String _firstname) {
        firstname = _firstname;
    }

    public void setLastname(String _lastname) {
        lastname = _lastname;
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

    public boolean getRole() {
        return role;
    }

    public void setRole(Boolean _role) {
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
