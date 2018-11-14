/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.CompSwimmer;

import Data.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
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

    TxtAccess acc = new TxtAccess();

    public void makePlayer(String name, LocalDate age, String address, String email, String number, boolean status, char MK) throws IOException {

        //create a member
        Member member = new Member(name, age, status, MK);
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
        System.out.println(list);

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        tw.textWriter("members.txt", nj);
        


//        for (Member x : list) {
//            if (x.getID() == "8") {
//            }
//        }
    }

    public void makeCompSwimmer(String name, LocalDate age, String address, String email, String number, boolean status, char MK, String desiplin) throws IOException {

                //create a member
        Member CompSwimmer = new CompSwimmer(name, age, status, MK, desiplin);
        acc.assignID(CompSwimmer);

        //make a list to keep members in
        List<CompSwimmer> list = new ArrayList<>();
        //read all the old members in

        String json = TextReader.textReader("CompSwimmer.txt");

        // add new member to list of members


        //put all members back in text file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        list = gson.fromJson(json, List.class);

        list.add(CompSwimmer);
        System.out.println(list);

        String nj = gson.toJson(list);

        TextWriter tw = new TextWriter();
        tw.textWriter("CompSwimmer.txt", nj);
        
        
        
    }
    
    
    
    
    
    
    

//    public Member createMemberTwo(String name, int age, boolean status) {
//        Member member = new Member(name, age, status);
//        acc.assignID(member);
//        acc.toFile(member);
//        return member;
//    }
}
