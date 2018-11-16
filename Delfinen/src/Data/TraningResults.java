/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;

/**
 *
 * @author kemokongshaug
 */
public class TraningResults {
    
    private String id;
    private int distance;
    private double time;
    private LocalDate date;

    
 
    
    // Part of the Coach Registrer Trainning Results, rest can be found in Controller
    public TraningResults(String id, int distance, double time, LocalDate date) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.date = date;
    }
    

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }
    
}
