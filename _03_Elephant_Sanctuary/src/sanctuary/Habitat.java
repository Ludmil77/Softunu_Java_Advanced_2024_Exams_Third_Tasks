package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat
{
    private int capacity;
    private List<Elephant> data;
    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public void add(Elephant elephant)
    {
        if(data.size() < capacity)
        {
            data.add(elephant);
        }
    }
    public boolean remove(String name)
    {
        Elephant elephant = data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(elephant != null)
        {
            data.remove(elephant);
            return true;
        }
        return false;
    }
    public Elephant getElephant(String retiredFrom)
    {
        return data.stream().filter(x -> x.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }
    public Elephant getOldestElephant()
    {
        return data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }
    public int  getAllElephants()
    {
        return data.size();
    }
    public String getReport()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Saved elephants in the park:%n"));
        for(Elephant elephant : data)
        {
            sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom()));
        }
        return sb.toString().trim();
    }
}
