/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package MedicationOrderSystem;

import MedicationOrderSystem.Forms.LoginGUI;
import java.sql.Connection;


/**
 *
 * @author Tüwüm
 */
public class MedicationOrderSystem {

    public static void main(String[] args) {
        System.out.println("Hello ProgEx! & Tim");
//        DBConnection con = new DBConnection();
//        System.out.println(con.getCon());
        new LoginGUI().setVisible(true);
    }
}
