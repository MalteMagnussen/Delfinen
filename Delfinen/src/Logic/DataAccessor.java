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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class DataAccessor {

    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }

    public Member getMember(char MK) {
        // If ID starts with M - create Member
        // If ID starts with K - create CompSwimmer

        if (MK == 'M') { // MEMBER
            try {
                DBConnector conn = new DBConnector();
                String query
                        = "SELECT * "
                        + "FROM member "
                        + "WHERE member_id = " + MK + ";";

                Connection connection = conn.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String name = "";
                LocalDate birthdate;
                int status;

                while (rs.next()) {
                    name = rs.getString("member_name");
                    birthdate = LocalDate.parse(rs.getString("member_age"));
                    
                    // Whether or not the Member is active or passive member.
                    status = rs.getInt("aktive");
                    boolean aktiv = false; 
                    if (status == 1) {
                        aktiv = true;
                    }
                    
                    // Create the member and return it.
                    Member member = new Member(name, birthdate, aktiv, MK);
                    return member;
                }
                return null;
            } catch (Exception ex) {
                Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (MK == 'K') { // Competition
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

            String query = "SELECT `member_id` FROM `delfinen`.`all_members` ORDER BY 'member_id' DESC;";

            Connection connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int ID = 0;
            if (rs.next()) {
                ID = Integer.parseInt(rs.getString("member_id").substring(1));
            }
            return ID;
        } catch (Exception ex) {
            Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
}
