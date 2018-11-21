/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;

public class Delfinen {

    private LocalDate year = LocalDate.of(2010, 1, 1); // Year the club was founded.
    private int clubYear = 0;

    public int getClubStart() {
        clubYear = year.getYear();
        return clubYear;
    }
}
