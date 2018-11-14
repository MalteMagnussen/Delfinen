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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mikkel
 */
public class Results {
    // Swimming results.
    // There exists Competitive results and Training results.

    // Metode to input the competitive results into the Database
    public void registerTResults(String id, int distance, double time, String date) {
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        // Puts the data into the DataBase while catching the errors if present
        try {
            conn = new DBConnector();
            query = "INSERT INTO `delfinen`.`konkurrence_results` VALUE (`" + id + "`, `" + distance + "`, `" + time + "`, `" + date + "`);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {

        } catch (Exception ex) {

        }
    }

    // Metode to input date from Trainning results into the DataBase
    public void registerKResults(String id, String competition, String placement, double time) {
        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;

        // Puts the data into the DataBase while catching the errors if present
        try {
            conn = new DBConnector();
            query = "INSERT INTO `delfinen`.`trainnings_res` VALUES (`" + id + "`, `" + competition + "`, `" + placement + "`, `" + time + "`);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {

        } catch (Exception ex) {

        }
    }

    // Metode to find Trainning results inside the Json file
    public ArrayList findTResults(String id) throws JSONException {
        // Pull's Data From Json 
        JSONObject obj = new JSONObject(JSON_DATA);
        JSONArray results = obj.getJSONArray("tResults");
        // New ArrayList containing the values
        ArrayList tResults = new ArrayList();
        // Integer to get the JSON's length
        int n = results.length();
        
        // Loop to find and get the data from Json
        for(int i = 0; i < n; ++i) {
            JSONObject result = results.getJSONObject(i);
            // Checks if the given id is the same as the one the loop is standing on at the moment
            if(id == result.getString("id")) {
                tResults.add(results.getJSONObject(i));
            }
        }
        return tResults;
    }

    // Metode to find Competitive results inside the Json File
    public ArrayList findKResults(String id) throws JSONException{
        // Pull's Data From Json 
        JSONObject obj = new JSONObject(JSON_DATA);
        JSONArray results = obj.getJSONArray("kResults");
        // New ArrayList containing the values
        ArrayList kResults = new ArrayList();
        // Integer to get the JSON's length
        int n = results.length();
        
        // Loop to find and get the data from Json
        for(int i = 0; i < n; ++i) {
            JSONObject result = results.getJSONObject(i);
            // Checks if the given id is the same as the one the loop is standing on at the moment
            if(id == result.getString("id")) {
                kResults.add(results.getJSONObject(i));
            }
        }
        return kResults;
    }

}
