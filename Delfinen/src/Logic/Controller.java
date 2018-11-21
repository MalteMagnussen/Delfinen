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
import java.util.function.Consumer;
import static jdk.nashorn.internal.runtime.JSType.toInteger;

/**
 *
 * @author benjamin Kongshaug
 */
public class Controller {

    TxtAccess acc = new TxtAccess();

    /**
     * Make a Member.
     *
     * @param name - Full name
     * @param birthDay - Birthday
     * @param city - City where they reside.
     * @param email - Email
     * @param number - Phone Number.
     * @param status - Status - Are they Active or Passive Members of Delfinen.
     * @param disciplin - Their Disciplin. "" empty String if they are not a
     * competition swimmer. "Crawl", "BackCrawl", "Butterfly", "Breast" if they
     * are a Competition Swimmer.
     */
    public void makeMember(String name, LocalDate birthDay, String city, String email, String number, boolean status, String disciplin) {
        //create a member
        Member member = new Member(name, birthDay, status, disciplin);
        acc.assignID(member);
        acc.initializePayment(member);
        //make a list to keep members in
        List<Member> list = acc.getMembers();
        list.add(member);
        acc.setMembers(list);
    }

    /**
     * Edit a Member.
     *
     * Only able to edit whether or not the Member is Active or Passive, and
     * what Disciplin he participates in. Change Disciplin to an empty String ""
     * if the person is no longer a Competitive Swimmer on a Team.
     *
     * @param id - ID of the Member.
     * @param status - Status of the Member. Active or Passive.
     * @param desiplin - Disciplin - Empty "", Crawl, Butterfly, BackCrawl,
     * Breast.
     */
    public void changeMember(String id, boolean status,
            String desiplin) {
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

    /**
     * Create training result in the Database.
     *
     * @param id - ID of whoevers result this is.
     * @param distance - Distance swam for this result.
     * @param time - Time it took to swim the distance.
     * @param date - Date the result took place.
     */
    public void MakeTrainingResult(String id, int distance, double time,
            LocalDate date) {
        TrainingResults tr = new TrainingResults(id, distance, time, date);
        List list = acc.getTrainingResults();
        list.add(tr);
        acc.setTrainingResults(list);
    }

    /**
     * OLD ONE
     * OLD ONE
     * Finds top five Swimmers on a Team.
     *
     * For more comments, check method below. It basically does the same thing.
     *
     * @param distance - The Distance you want to filter by.
     * @return - Returns Array of the best 5 Members ID for that Distance.
     */
    public String[] OLDFindTopFiveId(int distance) {
        String[] topFive = {"", "", "", "", ""};
        List list = acc.getTrainingResults();
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
     *
     * For more comments, check method below. It basically does the same thing.
     *
     * @param distance - The Distance you want to filter by.
     * @param Id
     * @return - Returns Array of the best 5 Members ID for that Distance.
     */
    //    Sortér træningsresultater så de står i rækkefølge 
//        med bedste øverst når man siger "find result".
//         BENJAMIN - Der skal bare laves lidt om i en kopi af FindTopFive.
    public String[] FindTopFiveId(int distance, String Id) {
        String[] topFive = {"", "", "", "", "","","","","",""};
        List<TrainingResults> list = acc.getTrainingResults();
        String bestTimeId = "";
        double max = Double.MAX_VALUE;
        int bestTimeIndex = 0;
        int topFiveIndex = 0;
        double bestTime;
        Member member = null;
        for (int i = 0; i < 5; i++) {
            for (int u = 0; u < list.size(); u++) {
                TrainingResults TR = list.get(u);
                if (distance == TR.getDistance()) {
                    double thisTR = TR.getTime();
                    if (thisTR < max && TR.getId().equals(Id)) {
                        bestTime = thisTR;
                        max = TR.getTime();
                        bestTimeId = TR.getId();
                        bestTimeIndex = u;
                        member = acc.getMember(bestTimeId);

                    }
                }

            }
            
            
            if(member != null){
                topFive[topFiveIndex] = member.getName();
                topFiveIndex++;
                topFive[topFiveIndex] = Integer.toString((int) max);
                topFiveIndex++;
                member = null;
                list.remove(bestTimeIndex);
            }
            
            max = Double.MAX_VALUE;
            bestTimeId = "";

        }
        return topFive;
    }

    /**
     * Finds top five Swimmers on a Team.
     *
     * @param JuniorSeniorPlusDisciplin - A very specific String. Has to be like
     * "JuniorButterfly" - Meaning, age first, then swimming style.
     * @return
     */
    public String[] FindTopFiveIdComp(String JuniorSeniorPlusDisciplin) {
        String[] topFive = {"", "", "", "", ""};
        // ^ Arrange the Array for the best Swimmers, in the given desiplin.
        List list = acc.getCompRes(JuniorSeniorPlusDisciplin);
        // ^ Get all the Competition Results from a Team.
        String bestTimeId = null;
        int max = 1000000000;
        int bestPlacementIndex = 0;
        int topFiveIndex = 0;

        for (int i = 0; i < 5; i++) { // Only loops 5 times,
            // Because we only want the top 5.
            for (int u = 0; u < list.size(); u++) {
                // Checks all the Competition Results from the given Discipline.
                CompRes CR = (CompRes) list.get(u);
                // Create one CompRes we can check on.
                int thisTR = toInteger(CR.getPlacement());
                // get the placement.
                boolean found = isInTopFive(CR.getID(), topFive);
                // Check whether or not we've already had this person 
                // in the top five.
                if (thisTR < max && !found) {
                    // If this person isn't already in the top 5
                    // and has a better placement than any previous swimmers
                    max = CR.getPlacement(); // saves the best found placement.
                    bestTimeId = CR.getID(); // saves the best ID.
                    bestPlacementIndex = u;  // So we can find the best result

                }

            }

            topFive[topFiveIndex] = bestTimeId; // Input into the return array
            topFiveIndex++; // increments.
            list.remove(bestPlacementIndex); // so it doesnt get used again

            max = 1000000000; // reset for new loop out of 5.
            bestTimeId = "";  // reset for new loop out of 5.

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
     * Get all Members who owes the club money.
     * 
     * @return Returns the names of all Members who haven't paid in full. You
     * can't EDIT a member without him having paid in full.
     */
    public String getNonPaid() {
        // Array that gets returned and shown in the UI.
        ArrayList<Payment> result = new ArrayList<>();
        // Array of all members to run through later
        List<Member> members = acc.getMembers();
        // The amount of years the Member has to have paid for.
        int year = LocalDate.now().getYear() - acc.del.getClubStart();
        // Check all the members.
        members.forEach((Member member) -> {
            // Find the ID of the Member we're looking at.
            String tempID = member.getID();
            // Find out how many years this member has paid for already.
            int yearsPaid = acc.findPayment(tempID);
            // If he hasn't paid for enough years
            if (yearsPaid < year) {
                // Then make a new payment
                Payment payment = new Payment(tempID);
                // Add it to the array of payments that are due.
                result.add(payment);
            }
        });
        // The string we return.
        String total = "";
        // Build the return string.
        for (int i = 0; i < result.size(); i++) {
            total += result.get(i).toString();
        }

        return total;
    }

    /**
     * Little help method to calculate amount owed based on age and membership
     * status.
     *
     * @param yearsNotPaid - Amount of years the member hasn't paid for.
     * @param member - The member we want to extort.
     * @return
     */
    public int getAmount(int yearsNotPaid, Member member) {
        int amount = 0;

        if (member.isStatus() == true) {
            if (member.getAge() < 18) {
                amount = 1000;
            } else if (member.getAge() <= 60 && member.getAge() >= 18) {
                amount = 1600;
            }
        }

        if (member.isStatus() == false) {
            amount = 500;
        }

        return (amount * yearsNotPaid);
    }

}
