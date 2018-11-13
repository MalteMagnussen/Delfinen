/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.CompSwimmer;
import Data.DBConnector;
import Data.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public Member getMember(String ID) {
        char MK = ID.charAt(0);
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

        return null;

    }

    public CompSwimmer getCompSwimmer(String ID) {
        char MK = ID.charAt(0);
        if (MK == 'K') { // Competition
            // TO - DO
            try {
                DBConnector conn = new DBConnector();
                String query
                        = "SELECT * "
                        + "FROM members"
                        + "WHERE member_id = " + MK + ";";

                Connection connection = conn.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String name = "";
                LocalDate birthdate;
                int status;

                while (rs.next()) {
                    birthdate = LocalDate.parse(rs.getString("member_age"));
                    name = rs.getString("member_name");
                    // Whether or not the Member is active or passive member.
                    status = rs.getInt("aktive");
                    boolean aktiv = false;
                    if (status == 1) {
                        aktiv = true;
                    }

                    // Create the member and return it.
                    CompSwimmer member = new CompSwimmer(name, birthdate, ID, aktiv);
                    return member;
                }
                return null;
            } catch (Exception ex) {
                Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
            }
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

            String query = "SELECT member_id FROM all_members ORDER BY member_id DESC;";

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

    public int getMoneyOwedForOneYear(String ID){ // To-Do
        int owed = 0;
        Member member = getMember(ID);
        // for one year.. Should calculate them all.
        if (member.isStatus() == false) return 500;
        if (member.getAge() > 18 && member.getAge() < 60) return 1600;
        if (member.getAge() < 18) return 1000;
        if (member.getAge() > 60) return 1200;
        return owed;
    }
    
    public ArrayList<String> getAllMembersID(){ // To-Do
        ArrayList<String> IDs = new ArrayList<>();
        try {
                DBConnector conn = new DBConnector();
                String query
                        = "SELECT member_id "
                        + "FROM member;";

                Connection connection = conn.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String ID = "";

                while (rs.next()) {
                    ID = rs.getString("member_id");
                    IDs.add(ID);
                }
                
                
                return null;
            } catch (Exception ex) {
                Logger.getLogger(DataAccessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return IDs;
    }
    
    // Input a year and it returns everyone who has paid that year.
    public ArrayList<String> getAllSubIDs(int year) {
        ArrayList<String> IDs = new ArrayList<>();
        
        
        
        
        
        
        
        return IDs;
    }
}

