/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import Data.Competitions;
import Data.Results;
import Data.TraningResults;
import Data.TxtAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import textreader.TextWriter;

/**
 *
 * @author benjamin Kongshaug
 */
public class Controller {

    TxtAccess acc = new TxtAccess();
//    private final String membersPath = "members.txt";
//    Gson gson = new Gson();

    public void makePlayer(String name, LocalDate age, String address, String email, String number, boolean status, String type) {

        //create a member
        Member member = new Member(name, age, status, type);
        acc.assignID(member);
        acc.initializePayment(member);

        //make a list to keep members in
        List<Member> list = acc.getMembers();
//        List<Member> list = new ArrayList<>();
//        //read all the old members in
//
//        String json = TextReader.textReader("members.txt");
//
//        // add new member to list of members
//        //put all members back in text file
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        list = gson.fromJson(json, List.class);
//        
        list.add(member);
        acc.setMembers(list); // Ny linje - Har lavet en metode der gør det der er udkommenteret nedenunder.
//        String nj = gson.toJson(list);
//
//        TextWriter tw = new TextWriter();
//        try {
//            tw.textWriter(membersPath, nj);
//            
////        for (Member x : list) {
////            if (x.getID() == "8") {
////            }
////        }
//        } catch (IOException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void changeMember(String id, boolean status,
            String desiplin) throws IOException {
     
        List<Member> list = acc.getMembers();
//        List<Member> list = new ArrayList<>();
        //read all the old members in
        
//        String json = TextReader.textReader(membersPath);

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        list = gson.fromJson(json, List.class);
        for (int i = 0 ; i < list.size();i++){
            Member member = list.get(i);
            if (member.getID().equals(id)) {
                      member.setStatus(status);
                      member.setType(desiplin);
            }
        }
        acc.setMembers(list);
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

//        String nj = gson.toJson(list);
//
//        TextWriter tw = new TextWriter();
//        tw.textWriter(membersPath, nj);
          
    }   
    public void MakeTraningResult(String id, int distance, double time, LocalDate date)
    {
        TraningResults tr = new TraningResults(id, distance,time, date);
        List list = acc.getTraningResults();
        list.add(tr);
        acc.setTraningResults(list);
    }
    

    public ArrayList<String> FindTopFiveId(String id, int distance)
    {
        List list = acc.getTraningResults();
        for (int i = 0; i<list.size();i++)
       
        
       
    }
    
    public void competitionRegistrer(String name) throws IOException {
        Competitions cpr = new Competitions(name);
        
        List list = acc.getCompetitions();
        
        //List<Results> cpn = new ArrayList<>();
        //String entry = cpr.registrerCompetition(name);
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        entry = gson.toJson(cpn);

    }
}
