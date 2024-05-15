package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium
{
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new ArrayList<>();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public void add(Fish fish)
    {
        Fish currentFish = findFish(fish.getName());
        if(currentFish == null && fishInPool.size() < capacity)
        {
            fishInPool.add(fish);
        }
    }
    public boolean  remove(String name)
    {
        Fish fish = findFish(name);
        if(fish != null)
        {
            fishInPool.remove(fish);
            return true;
        }
        return false;
    }
    public Fish findFish(String name)
    {
        return fishInPool.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
    public String  report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));
        for(Fish fish : fishInPool)
        {
            sb.append(fish.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
