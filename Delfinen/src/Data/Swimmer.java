/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalTime;

/**
 *
 * @author Malte
 */
public interface Swimmer {
    
    public LocalTime getAge (String ID);
    
    public String getName (String ID);
    
    public String getID (String name);
    
    
    
}
