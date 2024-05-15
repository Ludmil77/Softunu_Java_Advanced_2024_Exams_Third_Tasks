package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop
{
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity)
    {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public void addVehicle(Vehicle vehicle)
    {
        if(vehicles.size() < capacity)
        {
            vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin)
    {
        for(int i = 0; i < vehicles.size(); i++)
        {
            if(vehicles.get(i).getVIN().equals(vin))
            {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }
    public int getCount()
    {
        return vehicles.size();
    }
    public Vehicle getLowestMileage()
    {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vehicles in the preparatory:%n"));
        for(Vehicle vehicle : vehicles)
        {
            sb.append(vehicle.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
