package textreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class TextReader {



    /**
     *
     * @param filePath
     * @return 
     * @throws java.io.FileNotFoundException
     */

    public static String textReader(String filePath) throws FileNotFoundException, IOException
   {
   File path = new File(filePath);
   path.createNewFile();
   FileReader fr = new FileReader(path);
   BufferedReader reader = new BufferedReader(fr);
   String read = "";
   String line = reader.readLine();
   while (line != null)
   {
   read += line;
   read += "\n";
   
   line = reader.readLine();
   }
   reader.close();
      return(read);
       
   }


}
