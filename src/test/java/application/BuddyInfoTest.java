package application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo newbuddy;

    @Before
    public void setUp() throws Exception {
        newbuddy = new BuddyInfo("johan", "19", "501 kinderheim");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setname() {
        newbuddy.setName("francis");
        assertEquals("francis",newbuddy.getName());
    }

    @Test
    public void getname() {
        assertEquals("johan",newbuddy.getName());
    }

    @Test
    public void setage() {
        newbuddy.setAge("20");
        assertEquals("20",newbuddy.getAge());
    }

    @Test
    public void getage() {
        assertEquals("19",newbuddy.getAge());
    }

    @Test
    public void setadress() {
        newbuddy.setAdress("123 sesame st");
        assertEquals("123 sesame st",newbuddy.getAdress());
    }

    @Test
    public void getadress() {
        assertEquals("501 kinderheim",newbuddy.getAdress());
    }
}