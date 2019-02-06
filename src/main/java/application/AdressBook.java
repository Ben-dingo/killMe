package application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class AdressBook {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<BuddyInfo> buddies;

    public AdressBook() {
    }

    public static void main(String[] args) {
        System.out.println("Adress Book.");
        AdressBook contacts = new AdressBook();
        BuddyInfo newbuddy = new BuddyInfo("johan", "19", "501 kinderheim");
        contacts.addbuddy(newbuddy);
    }

    public AdressBook(ArrayList<BuddyInfo> buddies) {
        super();
    }

    public AdressBook(int id) {
        buddies = new ArrayList<BuddyInfo>();
        this.id = id;
    }

    public void addbuddy(String name, String age, String Adress) {
        BuddyInfo newbuddy = new BuddyInfo(name, age, Adress);
        buddies.add(newbuddy);
    }

    public void addbuddy(BuddyInfo newbuddy) {
        buddies.add(newbuddy);
    }

    public void removebuddy(BuddyInfo badbuddy) {
        buddies.remove(badbuddy);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}