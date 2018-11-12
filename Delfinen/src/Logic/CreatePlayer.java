/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Member;
import java.time.LocalTime;

/**
 *
 * @author benjamin Kongshaug
 */
public class CreatePlayer {

    public void MakePlayer(String name, LocalTime age, boolean status, char MK) {
        //create a member
        Member member = new Member(name, age, status, MK);
        //add to sql database
        
    }

}
