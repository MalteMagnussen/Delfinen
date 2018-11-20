/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Comparator;
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
    // Start of Converting it to File
    // String for id in both Trainning results and competitive result
    private String id;
    // Part of  registrer Trainning results
    private int distance;
    private double time;
    private LocalDate date;
    // Part of registrer Competitive results
    private String competition;
    private String placement;
    private double timeInRegistrer;

    String name = "";

    // Part of the Coach Registrer Trainning Results, rest can be found in Controller
    public void registerTResults(String id, int distance, double time, LocalDate date) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    // Part of the Coach Registrer Competitive Results, rest can be found in Controller
    public void registerKResults(String id, String competition, String placement, double time) {
        this.id = id;
        this.competition = competition;
        this.placement = placement;
        this.time = time;
    }

    // Metode to find Trainning results inside the Json file
    public ArrayList findTResults(String id) throws JSONException {
        // Pull's Data From Json 
        JSONObject obj = new JSONObject();
        JSONArray results = obj.getJSONArray("tResults");
        // New ArrayList containing the values
        ArrayList tResults = new ArrayList();
        // Integer to get the JSON's length
        int n = results.length();

        // Loop to find and get the data from Json
        for (int i = 0; i < n; ++i) {
            JSONObject result = results.getJSONObject(i);
            // Checks if the given id is the same as the one the loop is standing on at the moment
            if (id == result.getString("id")) {
                tResults.add(results.getJSONObject(i));
            }
        }
        //var sorted = tResults;
        //tResults.sort((a,b) -> parseDouble(a.time) - parseDouble(b.time)); 
        //list.sort(Comparator.comparingDouble(tResults::getTime));
        return tResults;
    }

    // Metode to find Competitive results inside the Json File
    public ArrayList findKResults(String id) throws JSONException {
        // Pull's Data From Json 
        JSONObject obj = new JSONObject();
        JSONArray results = obj.getJSONArray("kResults");
        // New ArrayList containing the values
        ArrayList kResults = new ArrayList();
        // Integer to get the JSON's length
        int n = results.length();

        // Loop to find and get the data from Json
        for (int i = 0; i < n; ++i) {
            JSONObject result = results.getJSONObject(i);
            // Checks if the given id is the same as the one the loop is standing on at the moment
            if (id == result.getString("id")) {
                kResults.add(results.getJSONObject(i));
            }
        }
        return kResults;
    }

   

    public void registrerCompetition(String name) {
        this.name = name;
    }
}
