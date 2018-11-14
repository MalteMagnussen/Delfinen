package delfinen;

import Data.Member;
import Logic.CreatePlayer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Malte, Mikkel, Benjamin, Nikolaj
 */
public class Delfinen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // git
        
        System.out.println("Hello Git!");
        System.out.println("new state!");
        System.out.println("I Want My Comp To Run Faster");
        CreatePlayer cp = new CreatePlayer();
        cp.makePlayer("Hanrik", LocalDate.of(1994, 04, 10), "address", "email", "number", true, 'M');
//        List<Member> list = new ArrayList<>();
//        Member m = new Member("Hanrik", LocalDate.of(1994, 04, 10), true, 'M');
//         Member m1 = new Member("Hanrik1", LocalDate.of(1994, 04, 10), true, 'M');
//         Member m2 = new Member("Hanrik2", LocalDate.of(1994, 04, 10), true, 'M');
//          Member m3 = new Member("Hanrik3", LocalDate.of(1994, 04, 10), true, 'M');
//           Member m4 = new Member("Hanrik4", LocalDate.of(1994, 04, 10), true, 'M');
//           list.add(m);
//           list.add(m1);
//           list.add(m2);
//           list.add(m3);
//           list.add(m4);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(list);
//        System.out.println(json);
//        
//        List<Member> list2 = gson.fromJson(json, List.class);
//        
//        for(Member x : list2){
//            if(x.getID() == "Hej"){
//                
//            }
//        }
        
    }
    
}
