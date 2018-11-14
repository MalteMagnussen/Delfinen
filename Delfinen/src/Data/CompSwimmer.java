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

    private ArrayList<String> disciplin;
    private String name;
    private LocalDate age;
    private String ID;
    private boolean status;

    public CompSwimmer(String name, LocalDate age, String ID, boolean status) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.status = status;
    }

    // Calculate Age from Birthday
    @Override
    public int getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
