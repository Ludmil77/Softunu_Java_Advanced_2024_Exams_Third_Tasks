package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic
{
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public void add(Pet pet)
    {
        if(data.size() < capacity)
        {
            data.add(pet);
        }
    }
    public boolean remove(String name)
    {
        Pet pet = data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(pet != null)
        {
            data.remove(pet);
            return true;
        }
        return false;
    }
    public Pet getPet(String name, String owner)
    {
        return data.stream().filter(x -> x.getName().equals(name) && x.getOwner().equals(owner)).findFirst().orElse(null);
    }
    public Pet getOldestPet()
    {
        return data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }
    public int getCount()
    {
        return data.size();
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The clinic has the following patients:%n"));
        for(Pet pet : data)
        {
            sb.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return sb.toString().trim();
    }
}
