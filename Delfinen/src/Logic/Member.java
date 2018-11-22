package Logic;

import java.time.LocalDate;

/**
 * Member Class.
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

    /**
     *
     * @param name Name of the Member.
     * @param birthday Birthday of the Member.
     * @param status True if active. False if passive.
     * @param type "" if regular member. "Butterfly" if its a competitive
     * swimmer in the Butterfly Discipline. Crawl, BackCrawl and Breast.
     */
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
     * @return Returns the Age as an int. Does not return the Birthday.
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
     * Only used when you edit a member.
     *
     * Because you basically delete the old member and make a new one, but with
     * the same ID.
     *
     * @param ID ID of the Member.
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
     * Is he an active Member who pays full membership price, or is he a passive
     * Member who only has to pay 500.
     *
     * @param ok True if you want to set Member to Active. False if you want to
     * set Member to Passive.
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
     * Used in Assign ID.
     *
     * @param newID ID you want to set it to.
     */
    public void setID(int newID) {
        this.ID = String.valueOf(newID);
    }

    /**
     * get the Type.
     *
     * Meaning type of competition Swimmer.
     *
     * @return String of Type. "" if not a competition swimmer.
     */
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
