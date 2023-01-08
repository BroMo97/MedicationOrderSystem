package MedicationOrderSystem.Classes;
import MedicationOrderSystem.Handler.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Class which handles the {@link Orders} within the project
 * @author patricia
 */

public class Orders {
    enum status {received, in_progess, ready}

    private int id = -1;
    private String order_name = null;
    private LocalDateTime order_date = null;

    //---------------------------- bin bis hier ---------------
    private String location = null;
    private java.util.ArrayList<User> participants = null;
    //private String attachementfiles;
    private String priority = null;
    //private String reminder = null;


    public Orders(int id, String name, User host,
    LocalDateTime dateTime, int duration,
    String location, String priority, ArrayList<User> participants) {
this.setId(id);
this.setName(name);
//this.setHost(host);
this.setDateTime(dateTime);
//this.setDuration(duration);
this.setLocation(location);
this.setParticipants(participants);
this.setPriority(priority);

}

public Orders(String name, User host,
    LocalDateTime dateTime, int duration,
    String location,String priority, ArrayList<User> participants) {

this.setName(name);
//this.setHost(host);
this.setDateTime(dateTime);
//this.setDuration(duration);
this.setLocation(location);
this.setParticipants(participants);
this.setPriority(priority);

}

public Orders(User user) {
//setHost(user);
setDateTime(LocalDateTime.now());
setParticipants(user);
}

//methods 
public void setId(int _id) {
id = _id;
}

public int getID() {
return id;
}

public String getName() {
if (order_name != null) {
    return order_name;
}
return "";
}

public void setName(String _name) {
order_name = _name;
}

//public User getHost() {
//return host;
//}
//
//public void setHost(User _host) {
//host = _host;
//}

public LocalDateTime getDateTime() {
if (order_date != null) {
    return this.order_date;
}
return LocalDateTime.MAX;
}

public void setDateTime(LocalDateTime _dateTime) {
order_date = _dateTime;
}

//public int getDuration() {
//return duration;
//}
//
//public void setDuration(int _duration) {
//duration = _duration;
//}

public String getLocation() {
if (location != null) {
    return location;
}
return "";
}

public void setLocation(String _location) {
location = _location;
}

public java.util.ArrayList<User> getParticipants() {
return participants;
}

public void setParticipants(java.util.ArrayList<User> _participants) {
participants = _participants;
}


public String getPriority() {
return priority;
}

public void setPriority(String _priority) {
priority = _priority;
}


//@Override
//public String toString() {
//return this.getName() + " "
//        + this.getDateTime().toLocalDate().toString() + " "
//        + this.getHost();
//}

@Override
public boolean equals(Object other) {

// If the object is compared with itself then return true   
if (other == this) {
    return true;
}

/* Check if other is an instance of User or not 
  "null instanceof [User]" also returns false */
if (!(other instanceof Orders)) {
    return false;
}

// Compare the usernames and return accordingly 
return this.id == ((Orders) other).id;
}

private void setParticipants(User user) {
if (this.participants == null) {
    this.participants = new ArrayList<User>();
}

this.participants.add(user);

}
}
