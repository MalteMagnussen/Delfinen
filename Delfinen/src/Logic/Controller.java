/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
        System.out.println(acc.getMembers());
        List<Member> list = acc.getMembers();
//        List<Member> list = new ArrayList<>();
        //read all the old members in
        
//        String json = TextReader.textReader(membersPath);

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        list = gson.fromJson(json, List.class);
        for (Member member : list){
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
}
