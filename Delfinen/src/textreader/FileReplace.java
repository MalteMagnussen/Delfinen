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
        text = TextReader.textReader(oldFilePath);

        String newText = text.replaceAll(findWord, replaceWord);
        TextWriter tw = new TextWriter();

        try {
            tw.textWriter(newFilePath, newText);

        } catch (IOException e) {
            e.getMessage();
        }
    }

}
