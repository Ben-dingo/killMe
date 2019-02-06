package application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdressBookController {

    private ArrayList<AdressBook> books = new ArrayList<AdressBook>();

    @GetMapping("/newBook")
    public String newBook(@RequestParam(name="id", required=false, defaultValue="1") String id) {
        int convert = Integer.parseInt(id);
        books.add(new AdressBook(convert));
        return "Success";
    }

    @GetMapping("/newBuddy")
    public String newBuddy(@RequestParam(name="id", required=false, defaultValue="1") String id, @RequestParam(name="name", required=true) String name, @RequestParam(name="address", required=true) String address, @RequestParam(name="age", required=true) String age) {
        int convert = Integer.parseInt(id);
        for (AdressBook addressbook: books) {
            if(addressbook.getId() == convert) {
                addressbook.addbuddy(name,age,address);
                return "Success";
            }
        }
        return "Failure";
    }

    @GetMapping("/viewBuddy")
    public String viewBuddy(@RequestParam(name="id", required=false, defaultValue="1") String id) {
        int convert = Integer.parseInt(id);
        for (AdressBook addressbook: books) {
            if(addressbook.getId() == convert) {
                return addressbook.getBuddies().toString();
            }
        }
        return "Failure";
    }

    @GetMapping("/removeBuddy")
    public String removeBuddy(@RequestParam(name="id", required=false, defaultValue="1") String id, @RequestParam(name="name", required=true) String name) {
        int convert = Integer.parseInt(id);
        for (AdressBook addressbook: books) {
            if(addressbook.getId() == convert) {
                for (BuddyInfo buddy : addressbook.getBuddies()){
                    if(buddy.getName().equals(name)){
                        addressbook.removebuddy(buddy);
                        return "Success";
                    }
                }
            }
        }
        return "Failure";
    }
}
