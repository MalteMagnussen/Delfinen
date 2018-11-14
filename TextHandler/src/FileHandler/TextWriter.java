/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Malte
 */
// Give it a string to put into a file and a path to where you want the file to go.
public class TextWriter {
    public static void textWriter(String toFile, String path) throws IOException{
        try (FileWriter outputStream = new FileWriter(path)) {
            outputStream.write(toFile);
        }
    }
}
