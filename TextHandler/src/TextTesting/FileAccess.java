/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextTesting;

import static FileHandler.TextWriter.textWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class FileAccess {

    String IDpath = "C:\\Users\\Malte\\Documents\\NetBeansProjects\\Delfinen\\ID.txt";

    public void assignID(Member member) {
        int res = 0;
        int newID = -1;
        String total = "";

        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(IDpath)));
            while (s.hasNext()) {
                String temp = s.next();
                total += " " + temp;
                if (Integer.parseInt(temp) > res) {
                    res = Integer.parseInt(temp);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        newID = res + 1;
        total += " " + newID;
        // Rewrites the ID file.
        try {
            textWriter(total, IDpath);
        } catch (IOException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        member.setID(newID);
    }

    public void toFile(Member member) {
        String tofile = "ID: " + member.getID() + ", Name: " + member.getName() + ", age: " + member.getAge() + ", status: " + member.isStatus() + ".";
        try {
            textWriter(tofile, "C:\\Users\\Malte\\Documents\\NetBeansProjects\\Delfinen\\Database\\" + member.getID() + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(FileAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        int high = highestID();

        for (int i = 0; i < high; i++) {
            String name = "";
            int age = 0;
            boolean status = true;
            try {
                Scanner s = new Scanner(new BufferedReader(new FileReader(IDpath)));
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            }

            Member member = new Member(name, age, status);
        }

        return members;
    }

    private int highestID() {
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
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
