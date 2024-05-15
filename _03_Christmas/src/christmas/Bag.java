package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag
{
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int count()
    {
        return data.size();
    }
    public void add(Present present)
    {
        if(data.size() < capacity)
        {
            data.add(present);
        }
    }
    public boolean remove(String name)
    {
        Present present = getPresent(name);
        if(present != null)
        {
            data.remove(present);
            return true;
        }
        return false;
    }
    public Present heaviestPresent()
    {
        return data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }
    public Present getPresent(String name)
    {
        return data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:%n", color));
        for(Present present : data)
        {
            sb.append(present.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
