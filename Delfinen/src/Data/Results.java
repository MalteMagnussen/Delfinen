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
    
    // ALL SQL. 
    
    // TO - DO - Convert to File-stuff.
    
    
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
    
    public ArrayList showTopResults(String choosenDisiplin) throws JSONException{
        // Pull's the Competitive Results from the JSON File
        JSONObject obj = new JSONObject("Insert Data");
        JSONArray results = obj.getJSONArray("tResults");
        int n = results.length();
        // Pull's the member list from the JSON File
        JSONObject obj2 = new JSONObject("INSERT DATE");
        JSONArray members = obj.getJSONArray("members");
        
        // New ArrayList over all members in the crawl category
        ArrayList crawl = new ArrayList();
        // New ArrayList over all members in the butterfly category
        ArrayList butterFly = new ArrayList();
        // New ArrayList over all members in the rygcrawl category
        ArrayList rygCrawl = new ArrayList();
        // New ArrayList over all members in the brystsvømning
        ArrayList brystSvømning = new ArrayList();
        // ArrayList to contain all the times 
        ArrayList allTimes = new ArrayList();
        // ArrayList to contain and return the top 5 results in whatever disiplin
        ArrayList top = new ArrayList();
        
        
        //int n = results.length();
        String disiplin = "";
        String times = "";
        String times2 = "";
        double time = 0;
        double time2 = 0;
        int distance = 0;
        int distance2 = 0;
        
        // Find's all the results and split them up into the different disiplins
        for(int i = 0; i < n; ++i) {
            JSONObject result = results.getJSONObject(i);
            disiplin = result.getString("disiplin");
            if(disiplin.equalsIgnoreCase("Crawl")){
                crawl.add(results.getJSONObject(i));
            }
            if(disiplin.equalsIgnoreCase("Rygcrawl")) {
                rygCrawl.add(results.getJSONObject(i));
            }
            if(disiplin.equalsIgnoreCase("Butterfly")) {
                butterFly.add(results.getJSONObject(i));
            }
            if(disiplin.equalsIgnoreCase("brystsvømning")) {
                brystSvømning.add(results.getJSONObject(i));
            }
            
        }
        
        // Loop to sort arraylist and get top 5 results
        if(choosenDisiplin.equalsIgnoreCase("crawl")) {
            // Loop to put the results into a new ArrayList
            for(int i = 0; i == crawl.size(); ++i) {
//                time = result.getString("time");
            }
        }
        
        if(choosenDisiplin.equalsIgnoreCase("rygcrawl")) {
            
        }
        
        if(choosenDisiplin.equalsIgnoreCase("butterfly")) {
            
        }
        
        if(choosenDisiplin.equalsIgnoreCase("brystsvømning")) {
            
        }
    }
}
