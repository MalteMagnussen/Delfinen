/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import Data.Competition;
import Data.Results;
import Data.TxtAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.JSType.toInteger;
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
        for (int i = 0; i < list.size(); i++) {
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

    public void MakeTrainingResult(String id, int distance, double time, LocalDate date) {
        TrainingResults tr = new TrainingResults(id, distance, time, date);
        List list = acc.getTraningResults();
        list.add(tr);
        acc.setTraningResults(list);
    }

    public String[] FindTopFiveId(int distance) {
        String[] topFive = {"","","","",""};
        List list = acc.getTraningResults();
        String bestTimeId = null;
        int max = 1000000000;
        int bestTimeIndex = 0;
        int topFiveIndex = 0;

        for (int i = 0; i < 5; i++) {
            for (int u = 0; u < list.size(); u++) {
                TrainingResults TR = (TrainingResults) list.get(u);
                if (distance == TR.getDistance()) {
                    int thisTR = toInteger(TR.getTime());
                    boolean found = isInTopFive(TR.getId(), topFive);
                    if (thisTR < max && !found) {
                        max = toInteger(TR.getTime());
                        bestTimeId = TR.getId();
                        bestTimeIndex = u;
                        
                        

                    }
                }

            }
            
            topFive[topFiveIndex] = bestTimeId;
            topFiveIndex ++;
            list.remove(bestTimeIndex);
            
            max = 1000000000;
            bestTimeId = "";

        }
        return topFive;

    }
    public boolean isInTopFive(String id, String[] list)
    {
    for(String thisId : list)
       {
       if (thisId.equals(id))
       {
       return true;
       }
       
       }
    return false;
    }
    


    public void competitionRegistrer(String name, LocalDate date) {
        Competition cpr = new Competition(name, date);
        List list = acc.getCompetitions();
        list.add(cpr);
        acc.setCompetition(list);
    }


    /**
     *
     * @param txtAccess
     * @return Returns the names of all Members who haven't paid in full.
     * You can't EDIT a member without him having paid in full.
     */
    public ArrayList<String> getNonPaid() {
        ArrayList<String> result = new ArrayList<>();
        List<Member> members = acc.getMembers();
        String total = "";
        int year = LocalDate.now().getYear() - acc.del.getClubStart();
        for (Member member : members) {
            String tempID = member.getID();
            int payment = acc.findPayment(tempID);
            if (payment != year) {
                result.add(member.getName());
            }
        }
        return result;
    }
}
