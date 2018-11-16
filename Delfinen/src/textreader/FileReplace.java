/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textreader;

import java.io.IOException;

public class FileReplace {

    public void fileReplace(String oldFilePath, String newFilePath, String findWord, String replaceWord) {
        String text = "";
        TextReader tr = new TextReader();

        try {
            text = TextReader.textReader(oldFilePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        String newText = text.replaceAll(findWord, replaceWord);
        TextWriter tw = new TextWriter();

        try {
            tw.textWriter(newFilePath, newText);

        } catch (IOException e) {
            e.getMessage();
        }
    }

}
