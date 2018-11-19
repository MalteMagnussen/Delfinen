/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.JSType.toInteger;

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
        list.add(member);
        acc.setMembers(list);
    }

    public void changeMember(String id, boolean status,
            String desiplin) throws IOException {
        //read all the old members in
        List<Member> list = acc.getMembers();

        for (int i = 0; i < list.size(); i++) {
            Member member = list.get(i);
            if (member.getID().equals(id)) {
                member.setStatus(status);
                member.setType(desiplin);
            }
        }
        acc.setMembers(list);

    }

    public void MakeTrainingResult(String id, int distance, double time, LocalDate date) {
        TrainingResults tr = new TrainingResults(id, distance, time, date);
        List list = acc.getTraningResults();
        list.add(tr);
        acc.setTraningResults(list);
    }

    public String[] FindTopFiveId(int distance) {
        String[] topFive = {"", "", "", "", ""};
        List list = acc.getTraningResults();
        String bestTimeId = null;
        double max = 1000000000;
        double bestTimeIndex = 0;
        int topFiveIndex = 0;

        for (int i = 0; i < 5; i++) {
            for (int u = 0; u < list.size(); u++) {
                TrainingResults TR = (TrainingResults) list.get(u);
                if (distance == TR.getDistance()) {
                    double thisTR = TR.getTime();
                    boolean found = isInTopFive(TR.getId(), topFive);
                    if (thisTR < max && !found) {
                        max = TR.getTime();
                        bestTimeId = TR.getId();
                        bestTimeIndex = u;

                    }
                }

            }

            topFive[topFiveIndex] = bestTimeId;
            topFiveIndex++;
            list.remove(bestTimeIndex);

            max = 1000000000;
            bestTimeId = "";

        }
        return topFive;
    }

    /**
     * Finds top five Swimmers on a Team.
     * @param JuniorSeniorPlusDisciplin - A very specific String. Has to be like
     * "JuniorButterfly" - Meaning, age first, then swimming style.
     * @return
     */
    public String[] FindTopFiveIdComp(String JuniorSeniorPlusDisciplin) {
        String[] topFive = {"", "", "", "", ""}; // Arrange the Array for the best Swimmers.
        List list = acc.getCompRes(JuniorSeniorPlusDisciplin); // Get all the Competition Results from a Team.
        String bestTimeId = null; 
        int max = 1000000000; 
        int bestPlacementIndex = 0;
        int topFiveIndex = 0; 

        for (int i = 0; i < 5; i++) {
            for (int u = 0; u < list.size(); u++) {
                CompRes CR = (CompRes) list.get(u);

                int thisTR = toInteger(CR.getPlacement());
                boolean found = isInTopFive(CR.getid(), topFive);
                if (thisTR < max && !found) {
                    max = CR.getPlacement();
                    bestTimeId = CR.getid();
                    bestPlacementIndex = u;

                }

            }

            topFive[topFiveIndex] = bestTimeId;
            topFiveIndex++;
            list.remove(bestPlacementIndex);

            max = 1000000000;
            bestTimeId = "";

        }
        return topFive;
    }

    /**
     * Help Method for FindTopFiveIdComp.
     *
     * @param id
     * @param list
     * @return
     */
    public boolean isInTopFive(String id, String[] list) {
        try {
            for (String thisId : list) {
                if (thisId.equals(id)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }

    /**
     * Creates a Competition (Laver et Stævne).
     *
     * @param name
     * @param date
     */
    public void competitionRegistrer(String name, LocalDate date) {
        Competition cpr = new Competition(name, date);
        List list = acc.getCompetitions();
        list.add(cpr);
        acc.setCompetition(list);
    }

    /**
     *
     * @return Returns the names of all Members who haven't paid in full. You
     * can't EDIT a member without him having paid in full.
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
