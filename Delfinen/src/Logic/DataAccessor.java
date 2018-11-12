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
import java.sql.Statement;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Malte
 */
public class DataAccessor {

    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }

    public Member getMember(String ID) {
        // If ID starts with M - create Member
        // If ID starts with K - create CompSwimmer
        
        if (ID.substring(0,1).equals("M")){ // MEMBER
            try {
                DBConnector conn = new DBConnector();
                String query
                        = "SELECT * "
                        + "FROM member "
                        + "WHERE ID = " + ID + ";";

                Connection connection = conn.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String name = "";
                LocalTime birthdate;
                boolean status;
                char MK;

                while (rs.next()) {
                    name = rs.getString("name");
                    birthdate = LocalTime.parse(rs.getString("password"));
                    status = rs.getBoolean("status");
                    MK = rs.getString("MK").charAt(0);
                    Member member = new Member(name, birthdate, status, MK);
                    return member;
                }
                return null;
            } catch (Exception ex) {
                Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ID.substring(0,1).equals("K")){ // KONKURRENCE
            // TO - DO
        }
        return null;
        
    }
    
    // Finds Highest ID out of ALL members. 

    /**
     *
     * @return
     */
    public int getHighestID() {
         
        try {
            DBConnector conn = new DBConnector();

            String query = "SELECT ID FROM `delfin`.`member` ORDER BY DESC;";

            Connection connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int ID = 0;
            if (rs.next()) {
                ID = Integer.parseInt(rs.getString("ID").substring(1));
            }
            return ID;
        } catch (Exception ex) {
            Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
}
