package MedicationOrderSystem.Handler;
import MedicationOrderSystem.Classes.*;

/**
 * Handler to handle {@link User} when they're registered
 * @author patricia
 */
public class UserHandler {
        
    /**
     * Checks wether Mail and Password are matching their confirmations
     * respectively
     * @param toBeConfirmed
     * @return true if Mail and password are matching
     */
    public boolean confirmationCheck(Registration toBeConfirmed){
        return toBeConfirmed.getEmail().equals(toBeConfirmed.getConfirm_email())    && 
                toBeConfirmed.getPassword().equals(toBeConfirmed.getConfirm_password());
        }
        
        /*
        checking if the textfilds are null at the registration -> cant be null 
        if null there comes a message like "please insert name" 
        */  
        /**
         * Checks the input of a user when he or she registrates
         * @param toBeChecked
         * @return true, if the input is valid, else false
         */
        public boolean CheckInput (Registration toBeChecked)
        {
            System.out.println(toBeChecked.getPassword());
            return (toBeChecked.getUsername().matches("^[a-zA-Z0-9_]{3,}$")
                    && toBeChecked.getFirstName().matches("^[a-zA-Z]{3,}$")
                    && toBeChecked.getLastName().matches("^[a-zA-Z]{3,}$")
                    && toBeChecked.getPassword().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$"));
              
        }
        
        /**
         * Check if user input and the confirmation input was valid
         * @param toBeCreated
         * @return true, if valid, else false 
         */
        public boolean tryToCreateNewUser(Registration toBeCreated)
        { 
            return !(!CheckInput(toBeCreated) ||!confirmationCheck(toBeCreated));
        }
        
        public User createNewUser(Registration toBeCreated,boolean EmailAvailable, boolean UsernameAvailable){
            User createdUser = null;
            
            if(!EmailAvailable || !UsernameAvailable)
                return createdUser;
            
            // public User(String name, String surname, String username, String email,
            // String gender, String address,LocalDateTime birthday,String phone, Rank _userRank ) 
            createdUser = 
                    new User(toBeCreated.getFirstName(),
                             toBeCreated.getLastName(),
                             toBeCreated.getUsername(),
                             toBeCreated.getEmail(), 
                             toBeCreated.getGender(),
                             toBeCreated.getAddress(),
                             toBeCreated.getBirthday(),
                             toBeCreated.getPhone(),
                             toBeCreated.getUserRank());
            
            
            
            //createdUser.setFirstname(toBeCreated.getFirstName());
            
            return createdUser;
        }

        
}
