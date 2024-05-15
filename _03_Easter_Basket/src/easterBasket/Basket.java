package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket
{
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Egg> getData() {
        return data;
    }

    public void setData(List<Egg> data) {
        this.data = data;
    }

    public void addEgg(Egg egg)
    {
        if(data.size() < capacity)
        {
            data.add(egg);
        }
    }
    public boolean removeEgg(String color)
    {
        Egg egg = getEgg(color);
        if(egg != null)
        {
            data.remove(egg);
            return true;
        }
        return false;
    }
    public Egg getStrongestEgg()
    {
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }
    public Egg getEgg(String color)
    {
        return data.stream().filter(x -> x.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount()
    {
        return data.size();
    }

    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", material));
        for(Egg egg : data)
        {
            sb.append(egg.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
