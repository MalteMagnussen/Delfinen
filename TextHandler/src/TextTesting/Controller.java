/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextTesting;

/**
 *
 * @author Malte
 */
public class Controller {
    public Member createMember(String name, int age, boolean status){
        Member member = new Member(name,age,status);
        FileAccess acc = new FileAccess();
        acc.assignID(member);
        acc.toFile(member);
        return member;
    }
}
