package halloween;

import java.util.ArrayList;
import java.util.List;

public class House
{
    private int capacity;
    private List<Kid> data;

    public House(int capacity)
    {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Kid> getData() {
        return data;
    }

    public void setData(List<Kid> data) {
        this.data = data;
    }
    public void addKid(Kid kid)
    {
        if(data.size() < capacity)
        {
            data.add(kid);
        }
    }
    public boolean removeKid(String name)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getName().equals(name))
            {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String street)
    {
        return data.stream().filter(s -> s.getStreet().equals(street)).findFirst().orElse(null);
    }
    public int getAllKids()
    {
        return data.size();
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Children who visited a house for candy:%n"));
        for(Kid kid : data)
        {
            sb.append(String.format("%s from %s street%n", kid.getName(), kid.getStreet()));
        }
        return sb.toString().trim();
    }
}
