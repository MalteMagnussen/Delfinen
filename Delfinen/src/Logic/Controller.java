/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import textreader.TextReader;
import textreader.TextWriter;
import static textreader.TextWriter.textWriterTwo;

/**
 *
 * @author benjamin Kongshaug
 */
public class Controller {

    TxtAccess acc = new TxtAccess();
    private final String membersPath = "members.txt";

    public void makePlayer(String name, LocalDate age, String address, String email, String number, boolean status) {

        //create a member
        Member member = new Member(name, age, status);
        acc.assignID(member);

        //make a list to keep members in
        List<Member> list = acc.getMembers();
//        List<Member> list = new ArrayList<>();
//        //read all the old members in
//
//        String json = TextReader.textReader("members.txt");
//
//        // add new member to list of members
//        //put all members back in text file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        list = gson.fromJson(json, List.class);
//        
        list.add(member);

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        try {
            tw.textWriter(membersPath, nj);
            
//        for (Member x : list) {
//            if (x.getID() == "8") {
//            }
//        }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeMember(String id, boolean status,
            String desiplin) throws IOException {
        List<Member> list = acc.getMembers();
//        List<Member> list = new ArrayList<>();
        //read all the old members in
        
//        String json = TextReader.textReader(membersPath);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        list = gson.fromJson(json, List.class);
        for (Member member : list){
            if (member.getID().equals(id)) {
                      member.setStatus(status);
                      member.setType(desiplin);
                      list.remove(member);
                      list.add(member);
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            Member member;
//            member = list.get(i);
//            if (member.getID().equals(id)) {
//                      member.setStatus(status);
//                      member.setType(desiplin);
//                      list.remove(i);
//                      list.add(i, member);
//            }
//        }

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        tw.textWriter(membersPath, nj);
    }    
}
