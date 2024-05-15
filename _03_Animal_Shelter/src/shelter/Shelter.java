package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter
{
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }
    public void add(Animal animal)
    {
        if(data.size() < capacity)
        {
            data.add(animal);
        }
    }
    public boolean remove(String name)
    {
        Animal animal = data.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
        if(animal != null)
        {
            data.remove(animal);
            return true;
        }
        return false;
    }
    public Animal getAnimal(String name, String caretaker)
    {
        return data.stream().filter(x -> x.getName().equals(name) && x.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }
    public Animal  getOldestAnimal()
    {
        return data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }
    public int getCount()
    {
        return data.size();
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:%n"));
        for(Animal animal : data)
        {
            sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker()));
        }
        return sb.toString();
    }
}
