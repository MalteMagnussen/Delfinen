/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Member;
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
public class CreatePlayer {

    TxtAccess acc = new TxtAccess();

    public void makePlayer(String name, LocalDate age, String address, String email, String number, boolean status) throws IOException {

        //create a member
        Member member = new Member(name, age, status);
        acc.assignID(member);

        //make a list to keep members in
        List<Member> list = new ArrayList<>();
        //read all the old members in

        String json = TextReader.textReader("members.txt");

        // add new member to list of members
        //put all members back in text file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        list = gson.fromJson(json, List.class);

        list.add(member);

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        tw.textWriter("members.txt", nj);

//        for (Member x : list) {
//            if (x.getID() == "8") {
//            }
//        }
    }

    public void changeMember(String id, boolean status,
            String desiplin) throws IOException {
        List<Member> list = new ArrayList<>();
        //read all the old members in
        
        String json = TextReader.textReader("members.txt");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        list = gson.fromJson(json, List.class);
        
        for (int i = 0; i < list.size(); i++) {
            Member member = list.get(i);
            if (member.getID().equals(id)) {
                      member.setStatus(status);
                      member.setType(desiplin);
                      list.remove(i);
                      list.add(i, member);
            }
        }

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        tw.textWriter("members.txt", nj);
    }
    
    // Used by the Kasserer. You input a Member ID
    // and the payment is put into the payments.txt file.
    public void payment(Integer ID){
        boolean run = true;
        
        String payment = "";
        String total = "";
        int pay = 0;
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("payments.txt")));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (run == true && next.startsWith(ID + "")) {
                    payment = next.substring(ID.toString().length()+1);
                    pay = Integer.parseInt(payment) + 1;
                    total += ID + " " + pay + "\n";
                    run = false;
                } else {
                    total += next + "\n";
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            textWriterTwo(total, "payments.txt");
        } catch (IOException ex) {
            Logger.getLogger(CreatePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
