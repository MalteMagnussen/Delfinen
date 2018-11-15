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
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextWriter {

    // Hand it a path in the directory and a message to put into that .txt file.
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

    // Hand it a path in the directory and a message to put into that .txt file.
    public static void textWriterTwo(String filePath, String message)  {
        try (FileWriter outputStream = new FileWriter(filePath)) {
            outputStream.write(message);
        } catch (IOException ex) {
            Logger.getLogger(TextWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
