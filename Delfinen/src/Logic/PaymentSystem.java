/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kemokongshaug
 */
public class PaymentSystem {
    
    
    // Ind sætter Betalt beløb ind i databasen
    public void registrerPayment(int id, int year, int payment) {
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        try {
            conn = new DBConnector();
            query = "INSERT INTO `delfinen`.`kontigent` VALUE (`"+id+"`, `"+year+"`, `"+payment+"`);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            

        } catch (SQLException ex) {

        } catch (Exception ex) {
            
            
        }
    }

    public ArrayList getAllPlayers() {
        return null;

    }

    public int getPlayerPayment(ArrayList swimmer) {
        return 0;

    }

    public void getAllPlatersPayment() {

    }

}
