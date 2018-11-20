/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Malte
 */
public class CompRes { // Competition Results. 

    private String ID;
    private Competition competition;
    private int placement;

    /**
     *
     * @param ID - ID of the Member whose Result this is.
     * @param competition - Competition that the Result happened at.
     * @param placement - Placement in said Competition.
     */
    public CompRes(String ID, Competition competition, int placement) {
        this.ID = ID;
        this.competition = competition;
        this.placement = placement;
    }

    public String getID() {
        return ID;
    }

    public Competition getCompetition() {
        return competition;
    }

    public int getPlacement() {
        return placement;
    }

}
