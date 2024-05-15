package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten
{
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        registry = new ArrayList<>();
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

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    public boolean addChild(Child child)
    {
        if(registry.size() < capacity)
        {
            registry.add(child);
            return true;
        }
        return false;
    }
    public boolean  removeChild(String firstName)
    {
        Child child = registry.stream().filter(f -> f.getFirstName().equals(firstName)).findFirst().orElse(null);
        if(child != null)
        {
            registry.remove(child);
            return true;
        }
        return false;
    }
    public int getChildrenCount()
    {
        return registry.size();
    }
    public Child getChild(String firstName)
    {
        return registry.stream().filter(f -> f.getFirstName().equals(firstName)).findFirst().orElse(null);
    }
    public String  registryReport()
    {
        List<Child> ordered = registry.stream().sorted(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:%n", name));
        for(Child child : ordered)
        {
            sb.append(String.format("--%n"));
            sb.append(child.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
