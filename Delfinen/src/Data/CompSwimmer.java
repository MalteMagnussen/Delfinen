/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Malte
 */
public class CompSwimmer implements Swimmer {

    private String disciplin; //Crawl, breast, butterfly, .....
    private String name;
    private LocalDate birthday;
    private String ID;
    private boolean status; // Status, as in Aktive or Passive Membership.

    public CompSwimmer(String name, LocalDate birthday, String ID, boolean status) {
        this.name = name;
        this.birthday = birthday;
        this.ID = ID;
        this.status = status;
    }

    // Calculate Age from Birthday
    @Override
    public int getAge() {
        int year = age.getYear();
        int currentYear = LocalDate.now().getYear();
        int age = Math.abs(year - currentYear);

        return age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public void setID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYearJoined() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
