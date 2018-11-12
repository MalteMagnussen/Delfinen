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
public class CompSwimmer extends Member {
    private ArrayList<String> disciplin;

    public CompSwimmer(String name, LocalTime age, String ID, boolean status) {
        super(name, age, ID, status);
    }
    
    
}
