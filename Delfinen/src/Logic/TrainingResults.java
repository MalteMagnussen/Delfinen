/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;

/**
 *
 * @author kemokongshaug
 */
public class TrainingResults {

    private String id;
    private int distance;
    private double time;
    private LocalDate date;
    private Member member;

    /**
     * Part of the Coach Registrer Trainning Results.
     *
     * The rest can be found in Controller.
     *
     * @param id - ID of the Member whose result this is.
     * @param distance - Distance swum.
     * @param time - Time it took to swim the distance.
     * @param date - Date that the result took place.
     */
    public TrainingResults(String id, int distance, double time, LocalDate date) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.date = date;
        setMember(); // Attaches a Member to the Training Result.
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

    /**
     * Attaches a Member to the Training Result.
     */
    private void setMember() {
        TxtAccess txtaccess = new TxtAccess();
        this.member = txtaccess.getMember(id);
    }

}
