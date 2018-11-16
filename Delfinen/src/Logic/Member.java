package Logic;

import java.time.LocalDate;

/**
 *
 * @author Malte
 */
public class Member implements Swimmer {

    private String name;
    private LocalDate birthday;
    private String ID;
    private boolean status;
    private int joinDate;
    private String type; // Determines whether or not you're a comp swimmer.
    // if 'NONE' you're a normal member.
    // if 'butterfly' or 'crawl' etc, you're a competition swimmer.

    public Member(String name, LocalDate birthday, boolean status, String type) {
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.joinDate = LocalDate.now().getYear();
        this.type = type;
    }

    // Returns the Age, not the Birthday.
    @Override
    public int getAge() {
        int year = birthday.getYear();
        int currentYear = LocalDate.now().getYear();
        int age = Math.abs(year - currentYear);

        return age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    // Only used when you edit a member.
    // Because you basically delete the old member and make a new one,
    // but with the same ID.
    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int getYearJoined() {
        return this.joinDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isStatus() {
        return status;
    }

    // If you call this, you flip the status of the member.
    public void setStatus(boolean ok) {
        if (ok == this.status) {
            return;
        }
        if (ok == true) {
            this.status = false;
        }
        if (ok == false) {
            this.status = true;
        }
    }

    public void setID(int newID) {
        this.ID = String.valueOf(newID);
    }

    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
}
