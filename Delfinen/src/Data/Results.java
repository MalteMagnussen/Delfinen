/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mikkel
 */
public class Results {
    // Swimming results.
    // There exists Competitive results and Training results.
    
    public void registerKResults(int id, int distance, double time, String date) {
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        try {
            conn = new DBConnector();
            query = "INSERT INTO `delfinen`.`konkurrence_results` VALUE (`"+id+"`, `"+distance+"`, `"+time+"`, `"+date+"`);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            

        } catch (SQLException ex) {

        } catch (Exception ex) {
            
            
        }
    }
    
    public void registerTResults(int id, String competition, String placement, double time) {
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        try {
            conn = new DBConnector();
            query = "INSERT INTO `delfinen`.`trainnings_results` VALUE (`"+id+"`, `"+competition+"`, `"+placement+"`, `"+time+"`);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            

        } catch (SQLException ex) {

        } catch (Exception ex) {
            
            
        }
    }
    
    
}
