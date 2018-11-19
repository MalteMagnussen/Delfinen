package Logic;

import java.time.LocalDate;

/**
 *
 * @author Malte
 */
public class Member {

    private String name;
    private LocalDate birthday;
    private String ID;
    private boolean status;
    private int joinDate;
    private String type;

    /* Type - Determines whether or not you're a comp swimmer.
    * if 'NONE' you're a normal member.
    * if 'butterfly' or 'crawl' etc, you're a competition swimmer. */
    public Member(String name, LocalDate birthday, boolean status, String type) {
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.joinDate = LocalDate.now().getYear();
        this.type = type;
    }

    /**
     * Get the Age of this Member.
     * 
     * @return - Returns the Age as an int.
     * Does not return the Birthday.
     */
    public int getAge() {
        int year = birthday.getYear();
        int currentYear = LocalDate.now().getYear();
        int age = Math.abs(year - currentYear);

        return age;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    /**
     * Only used when you edit a member. Because you basically delete the old
     * member and make a new one, but with the same ID.
     *
     * @param ID - ID of the Member.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    public int getYearJoined() {
        return this.joinDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isStatus() {
        return status;
    }

    /**
     * Set the Status of the Member.
     *
     * Meaning - Is he an active Member who pays full membership price, or is he
     * a passive Member who only has to pay 500.
     *
     * @param ok
     */
    public void setStatus(boolean ok) {
        if (ok == true) {
            this.status = true;
        }
        if (ok == false) {
            this.status = false;
        }
    }

    /**
     * Set a new ID.
     *
     * Used in Assign ID, and can be used if you don't want to do String.valueOf
     * everywhere.
     *
     * @param newID
     */
    public void setID(int newID) {
        this.ID = String.valueOf(newID);
    }

    /**
     * get the Type.
     *
     * Type Meaning type of competition Swimmer.
     *
     * @return
     */
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
