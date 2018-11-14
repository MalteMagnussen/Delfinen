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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class FileAccess {

    String IDpath = "ID.txt";

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
        String tofile = "ID:" + member.getID() + "\nName:" + member.getName() + "\nage:" + member.getAge() + "\nstatus:" + member.isStatus() + "";
        try {
            textWriter(tofile, member.getID() + ".txt");
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

    public Member getMember(int ID) {
        String name = "";
        int age = 0;
        boolean status = false;
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(ID + ".txt")));
            while (s.hasNext()) {
                String next = s.nextLine();
                if (next.startsWith("Name:")) {
                    next.trim();
                    name = next.substring(5);
                }
                if (next.startsWith("age:")) {
                    next.trim();
                    age = Integer.parseInt(next.substring(4));
                }
                if (next.startsWith("status:")) {
                    next.trim();
                    if (next.substring(8).equals(true)) status = true;
                    else status = false;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        Member member = new Member(name, age, status);    
        return member;
    }

    public void deleteFile(int ID){
        String strPath = ID+".txt";
        Path path = Paths.get(strPath);
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(FileAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
