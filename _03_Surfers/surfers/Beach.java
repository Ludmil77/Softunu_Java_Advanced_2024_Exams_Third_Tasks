package surfers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Beach
{
    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent)
    {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer)
    {
        if(!surfer.getOwnsASurfBoard())
        {
            if(surfboardsForRent > 0)
            {
                if(surfer.getMoney() >= 50)
                {
                    surfboardsForRent--;
                }
                else
                {
                    return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
                }
            }
            else
            {
                return "There are no free surfboards.";
            }
        }


        surfers.add(surfer);

        return String.format("Surfer %s added.", surfer.getName());


    }
    public boolean removeSurfer(String name)
    {
        Surfer surfer = surfers.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        return surfers.remove(surfer);
    }
    public String getMostExperiencedSurfer()
    {
        if(surfers.isEmpty())
        {
            return "There are no surfers.";
        }
        Surfer mostExperiencedSurfer = surfers.stream().max(Comparator.comparing(Surfer::getExperience)).orElse(null);
        return String.format("%s is most experienced surfer with %d years experience.",
                mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
    }
    public Surfer getSurfer(String name)
    {
        return surfers.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return surfers.size();
    }
    public String getSurfersWithPersonalSurfboards()
    {
        if(surfers.isEmpty())
        {
            return "There are no surfers.";
        }
        List<String> surfersNames = new ArrayList<>();
        for(Surfer surfer : surfers)
        {
            if(surfer.getOwnsASurfBoard())
            {
                surfersNames.add(surfer.getName());
            }
        }
        return String.format("Surfers who have their own surfboards: " + String.join(", ", surfersNames));
    }
    public String getReport()
    {
        StringBuilder sb = new StringBuilder();
        if(surfers.isEmpty())
        {
            return String.format("There are no surfers on %s beach.", name);
        }
        sb.append(String.format("Beach %s was visited by the following surfers:%n", name));
        int counter = 1;
        for(Surfer surfer : surfers)
        {
            if(surfer.getExperience() > 0)
            {
                sb.append(String.format("%d. %s with %d years experience.%n", counter, surfer.getName(), surfer.getExperience()));

            }
            else
            {
                sb.append(String.format("%d. %s with no experience.%n", counter, surfer.getName()));
            }
            counter++;
        }
        return sb.toString().trim();
    }
}
