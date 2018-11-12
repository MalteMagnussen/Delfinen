/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBConnector;
import Data.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author benjamin Kongshaug
 */
public class CreatePlayer {

    public void makePlayer(String name, LocalDate age, boolean status, char MK) {
        
        //create a member
        Member member = new Member(name, age, status, MK);
        //add to sql database
        
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        try {
            conn = new DBConnector();
            query = "SELECT * from Glarmester.wood;";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                String names = rs.getString("woodtype");
                int price = rs.getInt("price");
                System.out.println("" + names + price);
                
            }

        } catch (SQLException ex) {

        } catch (Exception ex) {
            
            
        }
        
        
        
    }
    public void makeCompSwimmer(String name, Time age, boolean status, char MK) {
        //create a CompSwimmer
       // CompSwimmer cSwimmer = new CompSwimmer(name, age, status, MK);
        
        //add to sql database
        
    }

}
