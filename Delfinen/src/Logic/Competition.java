/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;

/**
 *
 * @author Nikolaj
 */
public class Competition {
    
    private String name;
    private LocalDate LocalDate;

    public Competition(String name, LocalDate LocalDate) {
        this.name = name;
        this.LocalDate = LocalDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLocalDate() {
        return LocalDate;
    }
    
    
    
}
