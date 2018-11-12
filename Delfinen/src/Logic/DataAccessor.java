/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBConnector;
import Data.Member;
import Data.Team;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class DataAccessor {
    
    private DBConnector connector = null;

    DataAccessor(DBConnector connector) {
        this.connector = connector;
    }
//
//    // Returns the users that play on the team with the teamID that matches the parameter.
//    public ArrayList<Member> getTeamMembers(int team_id) {
//
//        try {
//            DBConnector conn = new DBConnector();
//
//            String query = "SELECT * FROM `teamwork`.`team` WHERE `team`.`team_id` = " + team_id + ";";
//
//            Connection connection = conn.getConnection();
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            String teamname = "";
//            while (rs.next()) {
//                teamname = rs.getString("teamname");
//            }
//
//            Team team = new Team(team_id, teamname);
//
//            return team.getMembers();
//
//        } catch (Exception ex) {
//            Logger.getLogger(DataAccessObject_impl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }

}
