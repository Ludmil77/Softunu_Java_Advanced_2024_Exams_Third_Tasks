package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel
{
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public void add(Person person)
    {
        if(roster.size() < capacity)
        {
            roster.add(person);
        }
    }
    public boolean remove(String name)
    {
        Person person = roster.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(person != null)
        {
            roster.remove(person);
            return true;
        }
        return false;
    }
    public Person getPerson(String name, String hometown)
    {
        return roster.stream().filter(x -> x.getName().equals(name) && x.getHometown().equals(hometown)).findFirst().orElse(null);
    }
    public int  getCount()
    {
        return roster.size();
    }

    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", name));
        for(Person person : roster)
        {
            sb.append(person.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
