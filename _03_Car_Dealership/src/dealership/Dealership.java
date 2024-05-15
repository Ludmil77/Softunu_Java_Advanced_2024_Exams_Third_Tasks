package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership
{
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
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

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public void add(Car car)
    {
        if(data.size() < capacity)
        {
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model)
    {
        Car car = getCar(manufacturer, model);
        if(car != null)
        {
            data.remove(car);
            return true;
        }
        return false;
    }

    public Car getLatestCar()
    {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer, String model)
    {
        return data.stream().filter(x -> x.getManufacturer().equals(manufacturer) && x.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return data.size();
    }

    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", name));
        for(Car car : data)
        {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
