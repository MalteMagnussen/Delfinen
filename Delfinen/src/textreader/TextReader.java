package textreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextReader {

    /**
     * Text Reader.
     * 
     * Reads the text with the given path and returns as a string.
     * 
     * @param filePath The path were the files are or will be stored locally.
     * @return A String.
     */
    public static String textReader(String filePath) {
        String read = "";
        try {
            File path = new File(filePath);
            path.createNewFile();
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                read += line;
                read += "\n";

                line = reader.readLine();
            }
            reader.close();
            return (read);
        } catch (IOException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
