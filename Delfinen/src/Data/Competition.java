/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Nikolaj
 */
public class Competition {
    
    private String name;
    private String LocalDate;

    public Competition(String name, String LocalDate) {
        this.name = name;
        this.LocalDate = LocalDate;
    }

    public String getName() {
        return name;
    }

    public String getLocalDate() {
        return LocalDate;
    }
    
    
    
}
