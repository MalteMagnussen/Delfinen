package textreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

    public static void main(String[] args) throws IOException {

        FileReplace FR = new FileReplace();
        FR.fileReplace("/Users/kemokongshaug/Desktop/filnavn.txt", "/Users/kemokongshaug/Desktop/andrefilen.txt", "file", "andrea");
    }

    /**
     *
     * @param filePath
     * @return 
     * @throws java.io.FileNotFoundException
     */
    public static String textReader(String filePath) throws FileNotFoundException, IOException {
        File path = new File(filePath);
        FileReader fr = new FileReader(path);
        BufferedReader reader = new BufferedReader(fr);
        String read = "";
        String line = reader.readLine();
        while (line != null) {
            read += line;
            read += "\n";

            line = reader.readLine();
        }
        reader.close();
        return (read);
    }

    public static String textReaderTwo(String filePath) throws FileNotFoundException {
        String res = "";
        Scanner s = new Scanner(new BufferedReader(new FileReader(filePath)));
        while (s.hasNextLine()) {
            res += s.nextLine() + "\r\n";
        }
        return res;
    }

}
