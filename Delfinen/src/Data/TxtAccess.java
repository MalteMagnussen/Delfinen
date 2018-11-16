/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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

    Gson gson = new Gson();
    private final String IDpath = "ID.txt";
    private final String membersPath = "members.txt";
    private final String paymentPath = "payments.txt";

    // Assigns a new ID to the given Member.
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

    // Removes the given ID from the ID.txt file.
    public void deleteID(String ID) {
        try {
            String total = "";
            File file = new File(IDpath);
            Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

            while (s.hasNext()) {
                String next = s.next();
                if (ID.equals(next)) {
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

    // Returns the highest integer in the ID .txt file.
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

    // Used by the Kasserer. You input a Member ID
    // and the payment is put into the payments.txt file.
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
        textWriterTwo(total, this.paymentPath);
    }

    // Returns a member. Hand it an ID.
    public Member getMember(String ID) {
        List<Member> members = getMembers();
        for (Member i : members) {
            if (ID.equals(i.getID())) {
                return i;
            } else {
            }
        }
        return null;
    }

    // Deletes a Member based on ID. 
    // Hand it an ID and the Member is removed from the File.
    public void deleteMember(String ID) {
        List<Member> members = getMembers();
        for (int i = 0 ; i < members.size() ; i++) {
            if (members.get(i).getID().equalsIgnoreCase(ID)) {
                deleteID(members.get(i).getID());
                members.remove(i);
            }
        }
        setMembers(members);
    }

    // Returns a list of all members.
    public List<Member> getMembers() {
        String json = TextReader.textReader(this.membersPath);

        Type listType = new TypeToken<ArrayList<Member>>(){}.getType();
        List<Member> members = gson.fromJson(json, listType);

        return members;
    }

    // Returns an ArrayList of strings of all IDs from ID.txt in the format: ID ID ID ID ID ...
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

    // Pretty prints members to file.
    public void setMembers(List<Member> members) {
//        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        textWriterTwo(membersPath, gson.toJson(members));
    }
    
    // Finds how many years the member with the ID has paid for.
    public String findPayment(String ID){
        String payment = "";
        // Finds the payment ID and adds one to its value.
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(this.paymentPath)));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (next.startsWith(ID)) {
                    payment = next.substring(ID.length() + 1);
                    return payment;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> getNonPaid(){
        ArrayList<String> result = new ArrayList<>();
        List<Member> members = getMembers();
        String total = "";
        Delfinen del = new Delfinen();
        int year = LocalDate.now().getYear() - del.getClubStart();
        for (Member member : members){
            String tempID = member.getID();
            String payment = findPayment(tempID);
            if (Integer.parseInt(payment) != year){
                result.add(member.getName());
            }
        }
        return result;
    }
}
