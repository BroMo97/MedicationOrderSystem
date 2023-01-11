package MedicationOrderSystem.Classes;
import MedicationOrderSystem.Handler.*;
import ENUMs.*;
import java.time.LocalDateTime;


public class Registration {
    private String username = null;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;
    private String confirm_email = null;
    private String confirm_password = null;
    private Gender gender = null; 
    private String address = null; 
    private LocalDateTime birthday = null;
    private String phone = null;
    private Rank userRank;

    public Registration(String username, String firstName, String lastName, String email, String password,
                        String confirm_email, String confirm_password) 
    {
        this.setUsername(username);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setConfirm_email(confirm_email);
        this.setConfirm_password(confirm_password);
    }

    public String getUsername() {
        if(username!=null)
            return username;
        return "";
    }

    public void setUsername(String username) {
        if (!username.isBlank()) {
            this.username = username;
        }
    }

    public String getFirstName() {
        if(firstName!=null)
            return firstName;
        return "";
    }

    public void setFirstName(String firstName) {
        if (!firstName.isBlank()) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
       if(lastName!=null)
            return lastName;
        return "";
    }

    public void setLastName(String lastName) {
        if (!lastName.isBlank()) {
            this.lastName = lastName;
        }
    }

    public String getEmail() {
        if(email!=null)
            return email;
        return "";
    }

    public void setEmail(String email) {
        if (!email.isBlank()) {
            this.email = email;
        }
    }
    
    public String getPassword() {
        if(password!=null)
            return password;
        return "";
    }

    public void setPassword(String password) {
        if (!password.isBlank()) {
            this.password = password;
        }
    }

    public String getConfirm_email() {
        if(confirm_email!=null)
            return confirm_email;
        return "";
    }

    public void setConfirm_email(String confirm_email) {
        if (!confirm_email.isBlank()) {
            this.confirm_email = confirm_email;
        }
    }

    public String getConfirm_password() {
        if(confirm_password!=null)
            return confirm_password;
        return "";
    }

    public void setConfirm_password(String confirm_password) {
        if (!confirm_password.isBlank()) {
            this.confirm_password = confirm_password;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Rank getUserRank() {
        return userRank;
    }

    public void setUserRank(Rank userRank) {
        this.userRank = userRank;
    }
    
    
}
