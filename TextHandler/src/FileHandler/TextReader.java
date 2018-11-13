/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class TextReader {

    public static String textReader(String filePath) throws FileNotFoundException {
        String res = "";
        Scanner s = new Scanner(new BufferedReader(new FileReader(filePath)));
        while (s.hasNextLine()) {
            res += s.nextLine() + "\r\n";
        }
        return res;
    }
}
