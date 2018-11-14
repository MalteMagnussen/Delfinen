/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBConnector;
import Data.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author benjamin Kongshaug
 */
public class CreatePlayer {

    public void makePlayer(String name, LocalDate age, boolean status, char MK) {

        //create a member
        //ne
        int year = age.getYear();
        Member member = new Member(name, age, status, MK);
        String id = member.getID();
        //add to sql database

        DBConnector conn = null;
        Connection connection;
        String query = "";
        ResultSet rs = null;
        int aktive = -1;

        try {
            if (status == true) {
                aktive = 1;
            } else {
                aktive = 0;
            }
            conn = new DBConnector();
            query = "insert into delfinen.member VALUES ('" + id + "','" + name + "' , " + aktive + ", " + year + ", null, null, 1);";
            connection = conn.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException ex) {

        } catch (Exception ex) {

        }

    }

    public void makeCompSwimmer(String name, Time age, boolean status, char MK) {
        //create a CompSwimmer
        // CompSwimmer cSwimmer = new CompSwimmer(name, age, status, MK);

        //add to sql database
    }

    public Member createMemberTwo(String name, int age, boolean status) {
        Member member = new Member(name, age, status);
        TxtAccess acc = new TxtAccess();
        acc.assignID(member);
        acc.toFile(member);
        return member;
    }
}
