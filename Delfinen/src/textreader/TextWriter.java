/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textreader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {

    public void textWriter(String filePath, String message) throws IOException {
        File path = new File(filePath);
        BufferedWriter writer = null;

        try {
            if (!path.exists()) {
                path.createNewFile();
            }
            FileWriter fw = new FileWriter(path);
            writer = new BufferedWriter(fw);
            writer.write(message);

        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }

    public static void textWriterTwo(String toFile, String path) throws IOException {
        try (FileWriter outputStream = new FileWriter(path)) {
            outputStream.write(toFile);
        }
    }
}
