/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Competition;
import Logic.CompRes;
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
    private String IDpath = "ID.txt";
    private String membersPath = "members.txt";
    private String paymentPath = "payments.txt";
    private String TrainingResultsPath = "TrainingResults.txt";
    private String competitionsPath = "competition.txt";
    public Delfinen del = new Delfinen();

    public void setIDpath(String IDpath) {
        this.IDpath = IDpath;
    }

    public void setMembersPath(String membersPath) {
        this.membersPath = membersPath;
    }

    public void setPaymentPath(String paymentPath) {
        this.paymentPath = paymentPath;
    }

    public void setTrainingResultsPath(String TraningResultsPath) {
        this.TrainingResultsPath = TraningResultsPath;
    }

    public void setCompetitionsPath(String competitionsPath) {
        this.competitionsPath = competitionsPath;
    }

    /**
     * Assign new ID to Member.
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
     * Delete ID from ID.txt.
     *
     * @param ID - of the Member whose ID you want to delete from the ID.txt
     * file.
     */
    public void deleteID(String ID) {
        try {
            String total = ""; // what we return to the file.
            File file = new File(IDpath);
            Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

            while (s.hasNext()) {
                String next = s.next();
                if (ID.equals(next)) {
                    total += ""; // If the ID we wanna Delete is found, 
                    // dont add it to the total.
                } else {
                    total += " " + next; // Else add it to the total.
                }
            }

            // Rewrites the ID file. Total is what we return.
            textWriterTwo(IDpath, total);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get Highest ID. Help Method.
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
     * Get specific Member by ID.
     *
     * @param ID - ID of the Member you want it to return.
     * @return a member.
     *
     */
    public Member getMember(String ID) {
        List<Member> members = getMembers();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getID().equals(ID)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Get a Member by his/her name.
     *
     * @param name - of the Member
     * @return - Returns the Member given in the Parameter.
     */
    public Member getMemberByName(String name) {
        List<Member> members = getMembers();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Deletes specific Member.
     *
     * @param ID - Hand it the ID of the member you wish to delete from the
     * system.
     */
    public void deleteMember(String ID) {
        List<Member> members = getMembers();
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getID().equalsIgnoreCase(ID)) {
                // Deleting everything to do with this member from the
                // different files.
                deleteID(member.getID());
                deleteAllPayments(member.getID());
                members.remove(member);
            }
        }
        setMembers(members);
    }

    /**
     * Get all Members in a List.
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
     * Get All IDs of Members.
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
     * @param members
     *
     */
    public void setMembers(List<Member> members) {
        textWriterTwo(membersPath, gson.toJson(members));
    }

    /**
     * Finds payments of the member with the given ID.
     *
     * @param ID - of the Member.
     * @return - Returns the int of how many years the member with the given ID
     * has paid.
     */
    public int findPayment(String ID) {
        String payment = "";
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {

                ArrayList<String> info = new ArrayList<>();

                // I need 4 pieces of info, So I loop 4 times.
                for (int i = 0; i < 4; i++) {
                    String next = s.next();
                    info.add(next);
                }

                String rain = info.get(0);
                // If the ID on the line matches the ID we're looking for
                if (rain.equals(ID)) {
                    payment = info.get(1);
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
     * Initialize the Payment file for this member.
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
            total += member.getID() + " " + yearsToPay + " 0 0\n";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        // Rewrites the file it.
        textWriterTwo(this.paymentPath, total);
    }

    /**
     * Assign single Payment to Member by ID.
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

                ArrayList<String> info = new ArrayList<>();

                // I need 4 pieces of info, So I loop 4 times.
                for (int i = 0; i < 4; i++) {
                    String next = s.next();
                    info.add(next);
                }

                // If the ID on the line matches the ID we're looking for
                if (info.get(0).equals(ID)) {
                    pay = Integer.parseInt(info.get(1));
                    pay = pay + 1;
                    info.set(1, String.valueOf(pay));
                }

                total += info.get(0) + " " + info.get(1) + " " + info.get(2) + " " + info.get(3) + "\n";
            }
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
     * Get all Training Results.
     *
     * @return - Returns a list of TrainingResults.
     */
    public List<TrainingResults> getTrainingResults() {
        String json = TextReader.textReader(TrainingResultsPath);

        Type listType = new TypeToken<ArrayList<TrainingResults>>() {
        }.getType();
        List<TrainingResults> TR = gson.fromJson(json, listType);

        return TR;
    }

    /**
     * Writes to file.
     *
     * @param trainingResults
     */
    public void setTrainingResults(List<TrainingResults> trainingResults) {
        //Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        textWriterTwo(TrainingResultsPath, gson.toJson(trainingResults));
    }

    /**
     * Get Competitions. (Stævner)
     *
     * @return - Returns a list of Competition.
     */
    public List<Competition> getCompetitions() {
        String json = TextReader.textReader(competitionsPath);
        Type listType = new TypeToken<ArrayList<Competition>>() {
        }.getType();
        List<Competition> CN = gson.fromJson(json, listType);
        return CN;
    }

    /**
     * Writes Competition to file.
     *
     * @param name - Name of Competition
     */
    public void setCompetition(List<Competition> name) {
        textWriterTwo(competitionsPath, gson.toJson(name));
    }

    /**
     * Competitive Results to File.
     *
     * @param result - Give it the Result to send to file for that member.
     */
    public void compResToFile(CompRes result) {
        Member member = getMember(result.getID());
        String jors = juniorOrSenior(member);
        String type = member.getType();
        String path = jors + type;
        List<CompRes> compres = getCompRes(path);
        compres.add(result);
        setCompRes(path, compres);
    }

    /**
     * Don't use it. It is a help method.
     *
     * @param compres
     * @param path
     */
    public void setCompRes(String path, List<CompRes> compres) {
        textWriterTwo(path + ".txt", gson.toJson(compres));
    }

    /**
     * Get Competition Results.
     *
     * @param path - Hand it the FilePath In the format "Junior" or "Senior" +
     * Disciplin "BackCrawl", "Crawl", "Butterfly", "Breast". Example if you
     * want Junior Backcrawl, hand it "JuniorBackCrawl".
     * @return - Returns Competition Results.
     */
    public List<CompRes> getCompRes(String path) {
        path = path + ".txt";
        String json = TextReader.textReader(path);

        Type listType = new TypeToken<ArrayList<CompRes>>() {
        }.getType();
        List<CompRes> CN = gson.fromJson(json, listType);

        return CN;
    }

    /**
     * Returns a single Competition Result.
     *
     * @param path The Path to the .txt File. Like - "JuniorCrawl" or
     * "SeniorButterfly"
     * @param comp The Competition the Result took place at.
     * @param ID The ID of the Member whose result you wish to find.
     * @param placement The Placement in the Competition.
     * @return Returns a Competition Result.
     */
    public CompRes getOneCompRes(String path, Competition comp, String ID, int placement) {
        List<CompRes> allCompRes = getCompRes(path);
        for (int i = 0; i < allCompRes.size(); i++) {
            CompRes compres = allCompRes.get(i);
            Competition icomp = compres.getCompetition();
            String iID = compres.getID();
            int iplacement = compres.getPlacement();
            if (iplacement == placement && ID.equals(iID) && icomp.equals(comp)) {
                return compres;
            }
        }
        return null;
    }

    /**
     * Returns whether they're senior or junior.
     *
     * @param member
     * @return - Junior / Senior
     */
    public String juniorOrSenior(Member member) {
        String jors = "Junior";
        int age = member.getAge();
        if (age < 18) {
            jors = "Junior";
        }
        if (age >= 18) {
            jors = "Senior";
        }
        return jors;
    }

    /**
     * DO NOT USE IN REAL PROGRAM - TESTING PURPOSES ONLY - resetsALLFiles.
     *
     * Used for Testing Purposes. It resets all files.
     */
    public void resetAllFiles() {
        String path = "competition.txt";
        textWriterTwo(path, "[]");

        path = "JuniorBackCrawl.txt";
        textWriterTwo(path, "[]");

        path = "JuniorBreast.txt";
        textWriterTwo(path, "[]");

        path = "JuniorButterfly.txt";
        textWriterTwo(path, "[]");

        path = "JuniorCrawl.txt";
        textWriterTwo(path, "[]");

        path = "SeniorBreast.txt";
        textWriterTwo(path, "[]");

        path = "SeniorButterfly.txt";
        textWriterTwo(path, "[]");

        path = "SeniorCrawl.txt";
        textWriterTwo(path, "[]");

        path = "SeniorBackCrawl.txt";
        textWriterTwo(path, "[]");

        path = "members.txt";
        textWriterTwo(path, "[]");

        path = "TrainingResults.txt";
        textWriterTwo(path, "[]");

        path = "ID.txt";
        textWriterTwo(path, "");

        path = "payments.txt";
        textWriterTwo(path, "");

    }
}
