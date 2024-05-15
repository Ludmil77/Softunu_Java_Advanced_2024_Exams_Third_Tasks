package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage
{
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
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

    public List<Rabbit> getData() {
        return data;
    }

    public void setData(List<Rabbit> data) {
        this.data = data;
    }

    public void add(Rabbit rabbit)
    {
        if(data.size() < capacity)
        {
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name)
    {
        Rabbit rabbit = data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(rabbit != null)
        {
            data.remove(rabbit);
            return true;
        }
        return false;
    }
    public void removeSpecies(String species)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getSpecies().equals(species))
            {
                data.remove(data.get(i));
                if(!data.isEmpty())
                {
                    i--;
                }
            }
        }
    }
    public Rabbit sellRabbit(String name)
    {
        Rabbit rabbit = data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(rabbit != null)
        {
            rabbit.setAvailable(false);
        }
        return rabbit;
    }
    public List<Rabbit> sellRabbitBySpecies(String species)
    {
        List<Rabbit> temp = new ArrayList<>();
        for(Rabbit rabbit : data)
        {
            if(rabbit.getSpecies().equals(species))
            {
                rabbit.setAvailable(false);
                temp.add(rabbit);
            }
        }
        return temp;
    }
    public int count()
    {
        return data.size();
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:%n", name));
        for(Rabbit rabbit : data)
        {
            if(rabbit.isAvailable())
            {
                sb.append(rabbit.toString()).append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
