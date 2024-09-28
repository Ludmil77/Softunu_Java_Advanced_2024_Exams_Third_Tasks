package vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation
{
     private String name;
     private int capacity;
     private int railGauge;
     private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
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

    public int getRailGauge() {
        return railGauge;
    }

    public void setRailGauge(int railGauge) {
        this.railGauge = railGauge;
    }

    public void addLocomotive(Locomotive locomotive)
    {

        if(locomotives.size() < capacity)
        {
            if(railGauge == locomotive.getGauge())
            {
                if(locomotives.contains(locomotive))
                {
                    throw new RuntimeException("This locomotive already exists!");

                }
                locomotives.add(locomotive);
            }
            else
            {
                int difference = Math.abs(getRailGauge() - locomotive.getGauge());
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.%n", difference);
            }
        }
        else
        {
            System.out.println("This train station is full!");
        }
    }
    public boolean removeLocomotive(String name)
    {
        Locomotive locomotive = locomotives.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        return locomotives.remove(locomotive);
    }
    public String getFastestLocomotive()
    {
        if(locomotives.isEmpty())
        {
            return "There are no locomotives.";
        }
        Locomotive fastest = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).orElse(null);
        return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                fastest.getName(), fastest.getMaxSpeed());
    }
   public String getLocomotive(String name)
   {
       Locomotive locomotive = locomotives.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
       if(locomotive != null)
       {
           return locomotive.toString();
       }
       return null;
   }
   public int getCount()
   {
       return locomotives.size();
   }
   public String getOldestLocomotive()
   {
       if(locomotives.isEmpty())
       {
           return "There are no locomotives.";
       }
       Locomotive oldest = locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).orElse(null);
       return oldest.getName();
   }
   public String getStatistics()
   {
       TrainStation trainStation = new TrainStation(getName(), getCapacity(), getRailGauge());
       StringBuilder sb = new StringBuilder();
       if(locomotives.isEmpty())
       {
           sb.append(String.format("There are no locomotives departing from %s station.", trainStation.getName()));
       }
       else
       {
           sb.append(String.format("Locomotives departed from %s:%n", trainStation.getName()));
           int counter = 1;
           for(Locomotive locomotive : locomotives)
           {

               sb.append(String.format("%d. %s%n", counter, locomotive.getName()));
               counter++;
           }
       }

       return sb.toString().trim();
   }
}
