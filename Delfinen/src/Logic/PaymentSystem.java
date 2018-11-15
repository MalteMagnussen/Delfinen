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
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            query = "INSERT INTO `delfinen`.`kontigent` VALUE (`" + id + "`, `" + year + "`, `" + payment + "`);";
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

    public ArrayList getAllPlayersPayment() throws JSONException{
        // Pull's the id Json File
        JSONObject obj2 = new JSONObject();
        JSONArray ids = obj2.getJSONArray("id's");
        int idsLen = ids.length();
        // Pull's Data From Json about the join Json Array
        JSONObject obj = new JSONObject();
        JSONArray  allYears = obj.getJSONArray("allYears");
        int years = 0;
        // Pull's the members from JSON File
        JSONObject obj3 = new JSONObject();
        JSONArray members = obj3.getJSONArray("members");
        // Array to put the members in who is missing to pay
        ArrayList notPaid = new ArrayList();
        // Loop to find and get the data from Json
        for(int i = 0; i == idsLen; ++i) {
            // Pulls the local year
            LocalDate currentYear = LocalDate.now();
            int year = currentYear.getYear();
            // The year the club was made
            int clubCele = 2010;
            // Gets the years since the club was made
            int clubInYears = year - clubCele;
            // Integer to get the JSON's length of all the years
            years = allYears.length();
            
            // Loop to see if the member has paid or not
            if(clubInYears - years < 0) {
                // Takes the member whith the id and stores it in an ArrayList
                notPaid.add(members.getJSONObject(i));
            }
        }
        // Spits out the Members that have not Paid
        return notPaid;
    }

}
