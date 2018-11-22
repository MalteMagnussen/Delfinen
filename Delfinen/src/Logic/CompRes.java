/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 * Competition Result.
 *
 * @author Malte
 */
public class CompRes {

    private String ID;
    private Competition competition;
    private int placement;

    /**
     * Create a single Competition Result.
     *
     * @param ID ID of the Member whose Result this is.
     * @param competition Competition that the Result happened at.
     * @param placement Placement in said Competition.
     */
    public CompRes(String ID, Competition competition, int placement) {
        this.ID = ID;
        this.competition = competition;
        this.placement = placement;
    }

    /**
     * Get ID.
     *
     * ID of the Member whose Result this is.
     *
     * @return String ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Get Competition.
     *
     * Competition the Result happened at.
     *
     * @return Competition.
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * Get Placement.
     *
     * Get the position the swimmer finished the race in.
     *
     * @return The finishing position in the Competition.
     */
    public int getPlacement() {
        return placement;
    }

}
