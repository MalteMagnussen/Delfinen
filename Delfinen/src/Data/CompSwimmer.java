/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Malte
 */
public class CompSwimmer implements Swimmer{
    private ArrayList<String> disciplin;
    private String name;
    private LocalTime age;
    private String ID;
    private boolean status;
    

    public CompSwimmer(String name, LocalTime age, String ID, boolean status) {
        this.name = name;
        this.age  = age;
        this.ID = ID;
        this.status = status;
    }

    @Override
    public LocalTime getAge(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
