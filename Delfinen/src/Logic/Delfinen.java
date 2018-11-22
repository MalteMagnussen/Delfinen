/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;

/**
 * Mainly just holds the date the club was founded. 
 */
public class Delfinen {

    /** 
     * The year the club was founded. Hardcoded.
     */
    private LocalDate year = LocalDate.of(2010, 1, 1); 
    private int clubYear = 0;

    public int getClubStart() {
        clubYear = year.getYear();
        return clubYear;
    }
}
