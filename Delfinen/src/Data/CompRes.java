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
class CompRes {

    private String name;
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
        this.name = name;
        this.competition = competition;
        this.placement = placement;
        this.time = time;
    }

    public String getName() {
        return name;
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
    
    @Override
    public String toString() {
        return "CompRes{" + '}';
    }
    
}
