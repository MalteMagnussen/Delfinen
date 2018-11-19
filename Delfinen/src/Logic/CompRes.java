/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Competition;
import com.google.gson.Gson;
import java.time.LocalDate;

/**
 *
 * @author Malte
 */
public class CompRes {

    // Competition Results.
    
    private String id;
    private Competition competition;
    private String placement;
    private LocalDate time;

    /**
     * 
     * @param name
     * @param competition
     * @param placement
     * @param time 
     */
    public CompRes(String name, Competition competition, String placement, LocalDate time) {
        this.id = name;
        this.competition = competition;
        this.placement = placement;
        this.time = time;
    }

    public String getid() {
        return id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public String getPlacement() {
        return placement;
    }

    public LocalDate getTime() {
        return time;
    }

    
    
}
