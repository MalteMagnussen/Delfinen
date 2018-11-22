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

    /**
     * Text Writer Org.
     * 
     * Hand it a path in the directory and a message to put into that .txt file.
     * 
     * @param filePath The path were the files are or will be stored locally.
     * @param message The text that will be added to the textfile.
     * @throws IOException Exception will be trown if the message doesn't hold anything.
     */
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

    /**
     * Text Writer Alt.
     * 
     * Hand it a path in the directory and a message to put into that .txt file.
     * 
     * @param filePath The path were the files are or will be stored locally.
     * @param message The text that will be added to the textfile.
     */
    public static void textWriterTwo(String filePath, String message) {
        try (FileWriter outputStream = new FileWriter(filePath)) {
            outputStream.write(message);
        } catch (IOException ex) {
            Logger.getLogger(TextWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
