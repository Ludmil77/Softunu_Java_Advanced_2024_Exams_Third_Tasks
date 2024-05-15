package spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad
{
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad (String name, int capacity)
    {
        this.name = name;
        this.capacity = capacity;
        spacecrafts = new ArrayList<>();
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

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }

    public void setSpacecrafts(List<Spacecraft> spacecrafts) {
        this.spacecrafts = spacecrafts;
    }

    public void addSpacecraft(Spacecraft spacecraft)
    {
        if(spacecrafts.size() < capacity)
        {
            spacecrafts.add(spacecraft);
        }
        else
        {
            System.out.println("This launchpad is at full capacity!");
        }
    }
    public boolean removeSpacecraft(String name)
    {
        for(int i = 0; i < spacecrafts.size(); i++)
        {
            if(spacecrafts.get(i).getName().equals(name))
            {
                spacecrafts.remove(i);
                return true;
            }
        }
        return false;
    }
    public String getHeaviestSpacecraft()
    {
        Spacecraft spacecraft = spacecrafts.stream().max(Comparator.comparing(Spacecraft::getWeight)).orElse(null);
        if(spacecraft != null)
        {
            return String.format("%s - %dkg.", spacecraft.getName(), spacecraft.getWeight());
        }
        return null;

    }
    public Spacecraft getSpacecraft(String name)
    {
        return spacecrafts.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return spacecrafts.size();
    }
    public List<Spacecraft> getSpacecraftsByMissionType(String missionType)
    {
        List<Spacecraft> suitableSpacecrafts = getSpacecrafts().stream().filter(spacecraft -> spacecraft.getMissionType().equals(missionType)).collect(Collectors.toList());
        if (suitableSpacecrafts.isEmpty())
        {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return suitableSpacecrafts;
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Spacecrafts launched from %s:%n", name));
        int counter = 1;
        for(Spacecraft spacecraft : spacecrafts)
        {
            sb.append(String.format("%d. %s%n", counter, spacecraft.getName()));
            counter++;
        }
        return sb.toString().trim();
    }
}
