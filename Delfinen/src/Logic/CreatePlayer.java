/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Data.DBConnector;
import Data.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import textreader.TextReader;
import textreader.TextWriter;

/**
 *
 * @author benjamin Kongshaug
 */
public class CreatePlayer {

    public void makePlayer(String name, LocalDate age, String address, String email, String number, boolean status, char MK) throws IOException {

        //create a member
        Member member = new Member(name, age, status, MK);
        //make a list to keep members in
        List<Member> list = new ArrayList<>();
        //read all the old members in
        
        String json = TextReader.textReader("members.txt");
        
        System.out.println(json);
        // add new member to list of members
        
        //put all members back in text file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        list = gson.fromJson(json, List.class);
       
       
        list.add(member);
        System.out.println(list);
        
        String nj = gson.toJson(list);
        
        TextWriter tw = new TextWriter();
        tw.textWriter("members.txt",nj);
     

        
//
//        for (Member x : list) {
//            if (x.getID() == "Hej") {
//
//            }
//        }

    }

    public void makeCompSwimmer(String name, Time age, boolean status, char MK) {
        //create a CompSwimmer
        // CompSwimmer cSwimmer = new CompSwimmer(name, age, status, MK);

        //add to sql database
    }

    public Member createMemberTwo(String name, int age, boolean status) {
        Member member = new Member(name, age, status);
        TxtAccess acc = new TxtAccess();
        acc.assignID(member);
        acc.toFile(member);
        return member;
    }
}
