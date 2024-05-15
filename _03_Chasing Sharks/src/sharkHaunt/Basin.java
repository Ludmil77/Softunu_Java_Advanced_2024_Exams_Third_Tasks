package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin
{
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity)
    {
        this.name = name;
        this.capacity = capacity;
        sharks = new ArrayList<>();
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

    public List<Shark> getSharks() {
        return sharks;
    }

    public void setSharks(List<Shark> sharks) {
        this.sharks = sharks;
    }

    public void addShark(Shark shark)
    {
        if(sharks.size() < capacity)
        {
            sharks.add(shark);
        }
        else
        {
            System.out.println("This basin is at full capacity!");
        }
    }
    public boolean removeShark(String kind)
    {
        for(int i = 0; i < sharks.size(); i++)
        {
            if(sharks.get(i).getKind().equals(kind))
            {
                sharks.remove(i);
                return true;
            }
        }
        return false;
    }
    public Shark getLargestShark()
    {
        return sharks.stream().max(Comparator.comparing(Shark::getLength)).orElse(null);
    }
    public Shark getShark(String kind)
    {
        return sharks.stream().filter(k -> k.getKind().equals(kind)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return sharks.size();
    }
    public int getAverageLength()
    {
        double averageLength = 0;
        double sum = 0;
        for(Shark shark : sharks)
        {
            sum += shark.getLength();
        }
        averageLength = sum / sharks.size();
        return (int) Math.floor(averageLength);
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sharks in %s:%n", name));
        for(Shark shark : sharks)
        {
            sb.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.%n",
                    shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()));
        }
        return sb.toString().trim();
    }
}
