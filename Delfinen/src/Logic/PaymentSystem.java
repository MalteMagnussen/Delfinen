/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBConnector;
import Data.TxtAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import textreader.TextReader;

/**
 *
 * @author kemokongshaug
 */
public class PaymentSystem {
    
        TxtAccess acc = new TxtAccess();

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

    public void getAllPlayersPayment() throws JSONException{
        ArrayList<String> IDs = new ArrayList<>();
        List<Member> members = acc.getMembers();
        for(Member m : members) {
            Delfinen n = new Delfinen();
            int temp = acc.getPayments(m.getID());
            if (temp != LocalDate.now().getYear()-n.getClubStart()){
                IDs.add(m.getID());
            }
        }
    }

//    public ArrayList () {
//        List<Member> members = acc.getMembers();
//
//        TextReader tr = new TextReader();
//        tr.textWriter(paymentsPath, nj);
//    }
}
