/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Member;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static textreader.TextWriter.textWriterTwo;

/**
 *
 * @author Malte
 */
public class TxtAccess implements DataAccess {

    String IDpath = "ID.txt";

    public void assignID(Member member) {
        int res = 0;
        int newID = 0;
        String total = "";
        File file = new File(IDpath);
        if (file.exists()) {
            try {
                Scanner s = new Scanner(new BufferedReader(new FileReader(file)));
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
        }
        newID = res + 1;
        total += " " + newID;
        // Rewrites the ID file.
        try {
            textWriterTwo(total, IDpath);
        } catch (IOException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        member.setID(newID);
    }
    
    public void deleteID(int ID){
        String total = "";
        File file = new File(IDpath);
        if (file.exists()) {
            try {
                Scanner s = new Scanner(new BufferedReader(new FileReader(file)));
                while (s.hasNext()) {
                    String next = s.next();
                    if (ID == Integer.parseInt(next)) {
                    } else {
                        total += " " + next;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Rewrites the ID file.
        try {
            textWriterTwo(total, IDpath);
        } catch (IOException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
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
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Member getMember(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
