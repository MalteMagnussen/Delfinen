/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

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
    private int placement;

    /**
     * 
     * @param id
     * @param competition
     * @param placement
     */
    public CompRes(String id, Competition competition, int placement) {
        this.id = id;
        this.competition = competition;
        this.placement = placement;
    }

    public String getid() {
        return id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public int getPlacement() {
        return placement;
    }


    
    
}
