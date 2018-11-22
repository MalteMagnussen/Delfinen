/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Competition.
 * 
 * @author Nikolaj
 */
public class Competition {

    private String name;
    private LocalDate LocalDate;

    /**
     * Constructor.
     * @param name Name of the Competition.
     * @param LocalDate Date of the Competition.
     */
    public Competition(String name, LocalDate LocalDate) {
        this.name = name;
        this.LocalDate = LocalDate;
    }

    /**
     * Get Name.
     * 
     * Get name of the Competition.
     * 
     * @return String of the Competition Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get Date.
     * 
     * Get the Date the Competition took place.
     * 
     * @return LocalDate
     */
    public LocalDate getLocalDate() {
        return LocalDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.LocalDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competition other = (Competition) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.LocalDate, other.LocalDate)) {
            return false;
        }
        return true;
    }

}
