/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Member;
import java.util.ArrayList;

/**
 *
 * @author Malte
 */
public interface DataAccess {

    public Member getMember(String ID);

    public int getHighestID();

    public String getAllIDs();

}
