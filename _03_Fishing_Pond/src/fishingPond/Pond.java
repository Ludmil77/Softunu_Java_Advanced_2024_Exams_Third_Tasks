package fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond
{
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity)
    {
        this.capacity = capacity;
        fishes = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }
    public void addFish(Fish fish)
    {
        if(fishes.size() < capacity)
        {
            fishes.add(fish);
        }
    }
    public boolean removeFish(String species)
    {
        for(int i = 0; i < fishes.size(); i++)
        {
            if(fishes.get(i).getSpecies().equals(species))
            {
                fishes.remove(i);
                return true;
            }
        }
        return false;
    }

    public Fish getOldestFish()
    {
        return fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }
    public Fish getFish(String species)
    {
        return fishes.stream().filter(s -> s.getSpecies().equals(species)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return fishes.size();
    }
    public int getVacancies()
    {
        return (capacity - fishes.size());
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fishes in the pond:%n"));
        for(Fish fish : fishes)
        {
            sb.append(fish.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
