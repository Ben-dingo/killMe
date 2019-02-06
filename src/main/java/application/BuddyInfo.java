package application;

import javax.persistence.*;

@Entity
public class BuddyInfo
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long page;
    private String name;
    private String age;
    private String adress;
   // private AdressBook book;

    public BuddyInfo(String name, String age, String adress)
    {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public BuddyInfo() {
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public String getAge()
    {
        return this.age;
    }
    public void setAdress(String adress)
    {
        this.adress = adress;
    }
    public String getAdress()
    {
        return this.adress;
    }
    public String toString()
    {
        return (this.name + ", " + this.age + ", " + this.adress);
    }

   /* @ManyToOne
    public AdressBook getBook()
    {
        return book;
    }
    public void setBook(AdressBook book)
    {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return (name.equals(buddyInfo.name) &&
                age.equals(buddyInfo.age) &&
                adress.equals(buddyInfo.adress));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }*/
}