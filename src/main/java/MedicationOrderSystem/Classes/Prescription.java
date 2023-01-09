package MedicationOrderSystem.Classes;

import java.time.LocalDateTime;

public class Prescription {
    private int id = -1;
    private String health_insurance = null;
    private String health_insurance_number = null;
    private String insurance_number = null;
    private String doctor_number = null;
    private String business_location_number = null;
    private LocalDateTime prescription_date = null;
    private String medication_1 = null;
    private String medication_2 = null;
    private String medication_3 = null;
    private String medication_4 = null;
    private String medication_5 = null;

//  wenn rezept schon in datenbank ist nutzen 
public Prescription(int id, String health_insurance, String health_insurance_number, String insurance_number, 
String doctor_number, String business_location_number, LocalDateTime prescription_date, String medication_1, String medication_2, 
String medication_3, String medication_4, String medication_5 ) {
    this.setId(id);
    this.setHealthInsurance(health_insurance_number);
    this.setHealthInsuranceNumber(health_insurance_number);
    this.setInsuranceNumber(health_insurance_number);
    this.setDoctorNumber(doctor_number);
    this.setBusinessocationNumber(business_location_number);
    this.setPrescriptionDate(prescription_date);
    this.setMedication1(medication_1);
    this.setMedication2(medication_2);
    this.setMedication3(medication_3);
    this.setMedication4(medication_4);
    this.setMedication5(medication_5);
}

// bitte beim eifügen eines neuen Rezepts einfügen
public Prescription(String health_insurance, String health_insurance_number, String insurance_number, 
String doctor_number, String business_location_number, LocalDateTime prescription_date, String medication_1, String medication_2, 
String medication_3, String medication_4, String medication_5 ) {
    
    this.setHealthInsurance(health_insurance_number);
    this.setHealthInsuranceNumber(health_insurance_number);
    this.setInsuranceNumber(health_insurance_number);
    this.setDoctorNumber(doctor_number);
    this.setBusinessocationNumber(business_location_number);
    this.setPrescriptionDate(prescription_date);
    this.setMedication1(medication_1);
    this.setMedication2(medication_2);
    this.setMedication3(medication_3);
    this.setMedication4(medication_4);
    this.setMedication5(medication_5);
}

//methods
public void setId(int _id) {
    id = _id;
    }
    
    public int getId() {
    return id;
    }

public void setHealthInsurance (String _health_insurance){
    health_insurance = _health_insurance;
}

public String getHealthInsurance (){
    return health_insurance;
}


public void setHealthInsuranceNumber (String _health_insurance_number){
    health_insurance = _health_insurance_number;
}

public String getHealthInsuranceNumber (){
    return health_insurance_number;
}

public void setInsuranceNumber (String _insurance_number){
    health_insurance = _insurance_number;
}

public String getInsuranceNumber (){
    return insurance_number;
}

public void setDoctorNumber (String _doctor_number){
    doctor_number = _doctor_number;
}

public String getDoctorNumber (){
    return doctor_number;
}

public void setBusinessocationNumber (String _business_location_number){
    business_location_number = _business_location_number;
}

public String getBusinessocationNumber (){
    return business_location_number;
}

public LocalDateTime getPrescriptionDate() {
    if (prescription_date != null) {
        return this.prescription_date;
    }
    return LocalDateTime.MAX;
    }
    
    public void setPrescriptionDate(LocalDateTime _prescription_date) {
        prescription_date = _prescription_date;
    }
  

public void setMedication1 (String _medication_1){
        medication_1 = _medication_1;
    }
    
public String getMedication1 (){
    if (medication_1 != null) {
        return medication_1;
    }
    return "";
    }   

    public void setMedication2 (String _medication_2){
        medication_2 = _medication_2;
    }
    
public String getMedication2 (){
    if (medication_2 != null) {
        return medication_2;
    }
    return "";
    } 
    
public void setMedication3 (String _medication_3){
        medication_3 = _medication_3;
    }
    
public String getMedication3 (){
    if (medication_3 != null) {
        return medication_3;
    }
    return "";
    }  

public void setMedication4 (String _medication_4){
        medication_4 = _medication_4;
    }
    
public String getMedication4 (){
    if (medication_4 != null) {
        return medication_4;
    }
    return "";
    }  


public void setMedication5 (String _medication_5){
        medication_5 = _medication_5;
    }
    
public String getMedication5 (){
    if (medication_5 != null) {
        return medication_5;
    }
    return "";
    }  
/* 
    public String getMedication() {
        if (medication != null) {
            return medication;
        }
        return "";
        }
*/
}
