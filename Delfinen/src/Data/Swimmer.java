/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;

/**
 *
 * @author Malte
 */
public interface Swimmer {
    
    public int getAge ();
    
    public String getName ();
    
    public String getID ();
    
    public void setID(String ID);
    
    public int getYearJoined();
    
}
