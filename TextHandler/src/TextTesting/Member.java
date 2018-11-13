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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class Member {

    int age;
    String name;
    boolean status;
    int ID;
    
    public Member(String name, int age, boolean status) {
        this.age = age;
        this.name = name;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
