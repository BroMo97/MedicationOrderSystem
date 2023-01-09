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
    private String medication = null;  //Medication
    private LocalDateTime order_date = null;
    private String status = null; 

    //---------------------------- bin bis hier ---------------
    
// constructor

    public Orders(int id, String mediaction, LocalDateTime order_date, String status ) {
        this.setId(id);
        this.setMedication(medication);
        this.setOrderDate(order_date);
        this.setStatus(status);
}

//--bitte diesen für neue Bestellung anlegen nutzen--
public Orders(String medication, LocalDateTime order_date){
    this.setStatus("received");
    this.setMedication(medication);
    this.setOrderDate(order_date);

}



//methods 
public void setId(int _id) {
id = _id;
}

public int getId() {
return id;
}

public String getMedication() {
if (medication != null) {
    return medication;
}
return "";
}

public void setMedication(String _medication) {
medication = _medication;
}



public LocalDateTime getOrderDate() {
if (order_date != null) {
    return this.order_date;
}
return LocalDateTime.MAX;
}

public void setOrderDate(LocalDateTime _orderdate) {
order_date = _orderdate;
}


public String getStatus() {
return status;
}

public void setStatus(String _status) {
status = _status;
}
}
/* 
@Override
public boolean equals(Object other) {

// If the object is compared with itself then return true   
if (other == this) {
    return true;
}

Check if other is an instance of User or not 
  "null instanceof [User]" also returns false 
if (!(other instanceof Orders)) {
    return false;
}
}*/

