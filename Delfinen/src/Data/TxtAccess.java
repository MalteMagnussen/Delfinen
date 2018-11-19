/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.TrainingResults;
import Logic.Delfinen;
import Logic.Member;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import textreader.TextReader;
import static textreader.TextWriter.textWriterTwo;

/**
 *
 * @author Malte
 */
public class TxtAccess {

    private Gson gson = new Gson();
    private final String IDpath = "ID.txt";
    private final String membersPath = "members.txt";
    private final String paymentPath = "payments.txt";
    private final String TraningResultsPath = "TraningResults.txt";
    private final String competitionsPath = "competition.txt";
    public Delfinen del = new Delfinen();

    /**
     *
     * @param member - Assigns a new ID to the given member.
     *
     */
    public void assignID(Member member) {
        // Finds highest current ID and adds 1.
        int newID = getHighestID() + 1;
        // Puts that at the end of all current IDs.
        ArrayList<String> allIDs = getAllIDs();
        String total = "";
        for (int i = 0; i < allIDs.size(); i++) {
            total += allIDs.get(i) + " ";
        }
        total += newID + " ";
        // Rewrites the ID file.
        textWriterTwo(IDpath, total);
        // Assigns the new ID to the member.
        member.setID(newID);
    }

    /**
     *
     * @param ID - of the Member whose ID you want to delete from the ID.txt
     * file.
     */
    public void deleteID(String ID) {
        try {
            String total = "";
            File file = new File(IDpath);
            Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

            while (s.hasNext()) {
                String next = s.next();
                if (ID.equals(next)) {
                    total += "";
                } else {
                    total += " " + next;
                }
            }

            // Rewrites the ID file.
            textWriterTwo(IDpath, total);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return - Returns the highest integer in the ID .txt file.
     */
    public int getHighestID() {
        int res = 0;
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(IDpath)));
            while (s.hasNext()) {
                int temp = Integer.parseInt(s.next());
                if (temp > res) {
                    res = temp;
                }
            }
        } catch (FileNotFoundException ex) {
            return res;
        }
        return res;
    }

    /**
     *
     * @param ID - You input a Member ID, and the payment is put into the
     * payments.txt file. This Method is used by the Kasserer.
     */
    public void payment(String ID) {
        boolean run = true;
        String payment = "";
        String total = "";
        int pay = 0;
        // Finds the payment ID and adds one to its value.
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (run == true && next.startsWith(ID)) {
                    payment = next.substring(ID.length() + 1);
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
        // Rewrites the file it.
        textWriterTwo(this.paymentPath, total);
    }

    /**
     *
     * @param ID - ID of the Member you want it to return.
     * @return a member.
     *
     */
    public Member getMember(String ID) {
        List<Member> members = getMembers();
        for (Member i : members) {
            if (ID.equals(i.getID())) {
                return i;
            } else {
            }
        }
        throw new IllegalArgumentException("Name Doesn't Exist in Data.");
    }

    /**
     *
     * @param ID - Hand it the ID of the member you wish to delete from the
     * system.
     */
    public void deleteMember(String ID) {
        List<Member> members = getMembers();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getID().equalsIgnoreCase(ID)) {
                deleteID(member.getID());
                deleteAllPayments(member.getID());
                members.remove(member);
            }
        }
        setMembers(members);
    }

    /**
     *
     * @return - Returns a List of all members.
     */
    public List<Member> getMembers() {
        String json = TextReader.textReader(this.membersPath);
        Type listType = new TypeToken<ArrayList<Member>>() {
        }.getType();
        List<Member> members = gson.fromJson(json, listType);
        return members;
    }

    /**
     *
     * @return - Returns an ArrayList of all IDs of all Members.
     */
    public ArrayList<String> getAllIDs() {
        ArrayList<String> res = new ArrayList<>();
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(IDpath)));
            while (s.hasNext()) {
                res.add(s.next() + " ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * Pretty prints the members to the members.txt file.
     *
     * @param members
     *
     */
    public void setMembers(List<Member> members) {
//        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        textWriterTwo(membersPath, gson.toJson(members));
    }

    /**
     *
     * @param ID - of the Member.
     * @return - Returns the int of how many years the member with the given ID
     * has paid.
     */
    public int findPayment(String ID) {
        String payment = "";
        // Finds the payment ID and adds one to its value.
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (next.startsWith(ID)) {
                    payment = next.substring(ID.length() + 1);
                    return Integer.valueOf(payment);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        throw new IllegalArgumentException("ID Doesn't Exist in Data.");
    }

    /**
     *
     * @param member - Initialize this member in the Payments.txt file. Only
     * used when creating a member.
     */
    public void initializePayment(Member member) {
        int yearJoined = member.getYearJoined();
        int delStart = del.getClubStart();
        int yearsToPay = yearJoined - delStart;

        String total = "";

        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {
                String next = s.nextLine();
                total += next + "\n";
            }
            total += member.getID() + " " + yearsToPay + "\n";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        // Rewrites the file it.
        textWriterTwo(this.paymentPath, total);

    }

    /**
     * Deletes all payments of the given member with the Parameter ID.
     *
     * @param ID - Only used when deleting a member.
     */
    public void deleteAllPayments(String ID) {
        boolean run = true;
        String total = "";
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (next.startsWith(ID) && run == true) {
                    run = false;
                } else {
                    total += next + "\n";
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        // Rewrites the file it.
        textWriterTwo(this.paymentPath, total);
    }

    /**
     *
     * @return - Returns a list of TrainingResults.
     */
    public List<TrainingResults> getTraningResults() {
        String json = TextReader.textReader(TraningResultsPath);

        Type listType = new TypeToken<ArrayList<TrainingResults>>() {
        }.getType();
        List<TrainingResults> TR = gson.fromJson(json, listType);

        return TR;
    }

    /**
     * Writes to file.
     * @param traningResults 
     */
    public void setTraningResults(List<TrainingResults> traningResults) {
//        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        textWriterTwo(TraningResultsPath, gson.toJson(traningResults));
    }

    /**
     *
     * @param name - of the Member
     * @return - Returns the Member given in the Parameter.
     */
    public Member getMemberByName(String name) {
        List<Member> members = getMembers();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        throw new IllegalArgumentException("Name Doesn't Exist in Data.");
    }

    /**
     *
     * @return - Returns a list of Competitions.
     */
    public List<Competitions> getCompetitions() {
        String json = TextReader.textReader(competitionsPath);

        Type listType = new TypeToken<ArrayList<Competitions>>() {
        }.getType();
        List<Competitions> CN = gson.fromJson(json, listType);

        return CN;
    }

    /** 
     * Writes to file.
     * @param name 
     */
    public void setCompetition(List<Competitions> name) {
        textWriterTwo(competitionsPath, gson.toJson(name));
    }
    
    /**
     * 
     * @param member
     * @return - Returns whether they're senior or junior.
     */
    public String juniorOrSenior(Member member){
        String jOrS = "";
        int age = member.getAge();
        if (age < 18) jOrS = "Junior";
        if (age >= 18) jOrS = "Senior";
        return jOrS;
    }
}
