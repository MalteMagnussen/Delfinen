package delfinen;

import Logic.Competition;
import Data.TxtAccess;
import Logic.CompRes;
import Logic.Member;
import Logic.Controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Malte, Mikkel, Benjamin, Nikolaj
 */
public class Delfinen {

/*
    TO DO START.
    
    Vi skal aflevere:
    "Tekstfil med link til github repository 
    (indeholdende kildekode, kravspecifikation og evt. dokumentation)."
    Så vi skal lige have spurgt om hvordan man sletter filer i github, 
    da der ligger en del ting som er unødvendige og som ikke bruges i
    projektet.
    
    KASSERER:

         LOGIC
DONE    I restance skal der vises antal år der mangler og vedkommendes ID.
         MALTE
       
         LOGIC
DONE    Hvor meget skal et member betale? 
         MALTE
    
    
    FORMAND:
        
         GUI
        I "ændre medlem" i formand skal der være en linje i dropdown 
DONE    hvor man stopper med at være competitive. 
        Den skal bare sætte disciplin til "".
         MIKKEL

         GUI
        Der skal være en ny knap der hedder "Find Person"
DONE    Den skal vise alt om en member.
            Comment: bare kald getmember(ID) og så bare .get på diverse info 
                     og smæk det ind i text felter.
         MIKKEL            
        

    TRÆNER:
    
         LOGIC
        Sortér træningsresultater så de står i rækkefølge 
DONE    med bedste øverst når man siger "find result".
         BENJAMIN - Der skal bare laves lidt om i en kopi af FindTopFive.
    
         DATA / LOGIC
Done    "Find Results" Skal ses på igen.
         BENJA 
    
         GUI
DONE    Implementerede Competition Results og Competition.
         MIKKEL
    
         GUI
DONE    I indberet resultat for stævne skal det være placering og ikke distance.
         MIKKEL

    
    TESTS:
    
        TESTS - Jacocoverage - Tjekker test coverage - Mål er 80%. 
         Brug JaCoCoverage. Hver class skal ramme ca 80% coverage.
    
    GIT:
    
        README.txt - Hvis andre skulle overtage det her projekt, hvad skal de så have at vide? 
DONE    - Laver vi som noget af det sidste torsdag inden vi afleverer.
    
    
    
    
    TO DO END.
*/
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//  Controller c = new Controller();
        TxtAccess at = new TxtAccess();
        Controller c = new Controller();
      at.resetAllFiles();
     String[] a =  c.FindTopFiveIdComp("SeniorButterfly");
     String b = "";
     for (String av : a)
     {
     b+= av + "\n";
     }
        System.out.println(b);
     
//        String[] str = c.FindTopFiveId( 100, "2");
//        for(String s : str){
//            System.out.println(s);
        
//        c.makePlayer("Malte", LocalDate.of(2005, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true, "Butterfly");
//        c.makePlayer("Mikkel", LocalDate.of(2000, Month.NOVEMBER, 05), "Odense", "Mikkel@email.com", "112", true, "Butterfly");
//        c.makePlayer("Benjamin", LocalDate.of(1990, Month.JUNE, 05), "Kbh", "Benjamin@email.com", "123123", true, "Butterfly");
//        c.makePlayer("Nikolaj", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "Butterfly");
//            c.makePlayer("1", LocalDate.now(), "ds", "fsd", "fsd", true, "butterfly");
//            c.makePlayer("2", LocalDate.now(), "ds", "fsd", "fsd", true, "butterfly");
//            c.makePlayer("3", LocalDate.now(), "ds", "fsd", "fsd", true, "butterfly");
//            c.makePlayer("4", LocalDate.now(), "ds", "fsd", "fsd", true, "butterfly");
//            c.makePlayer("5", LocalDate.now(), "ds", "fsd", "fsd", true, "butterfly");
//        Competition comp = new Competition("comp", LocalDate.now());
//        CompRes CR = new CompRes("1", comp, 1);
//        CompRes CR2 = new CompRes("2", comp, 2);
//        CompRes CR3 = new CompRes("3", comp, 3);
//        CompRes CR4 = new CompRes("4", comp, 4);
//        at.compResToFile(CR);
//        at.compResToFile(CR2);
//        at.compResToFile(CR3);
//        at.compResToFile(CR4);
//////        

//        c.MakeTraningResult("aa", 2, 2.1, LocalDate.now());
//        c.MakeTraningResult("aa", 2, 3.1, LocalDate.now());
//        c.MakeTraningResult("ab", 2, 4.1, LocalDate.now());
//        c.MakeTraningResult("ac", 2, 5.1, LocalDate.now());
//        c.MakeTraningResult("ad", 2, 6.1, LocalDate.now());
//        c.MakeTraningResult("ag", 6, 12.1, LocalDate.now());
//        c.MakeTraningResult("asa", 2, 13.1, LocalDate.now());
//        c.MakeTraningResult("aas", 2, 14.1, LocalDate.now());
//        c.MakeTraningResult("hades", 6, 15.1, LocalDate.now());
//////////System.out.println(Arrays.toString(c.FindTopFiveIdComp("JuniorButterfly")));
//        TxtAccess cont = new TxtAccess();
//        System.out.println(cont.getAllIDs());
//        System.out.println(cont.getHighestID());
//        
        // git
//        System.out.println("Hello Git!");
//        System.out.println("new state!");
//        System.out.println("I Want My Comp To Run Faster");
//        Controller cp = new Controller();
//        cp.makePlayer("Hanrik", LocalDate.of(1994, 04, 10), "address", "email", "number", true);
//        cp.changeMember(13, false, desiplin);
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
