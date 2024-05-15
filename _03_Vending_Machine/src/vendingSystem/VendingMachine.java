package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VendingMachine
{
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity)
    {
        this.buttonCapacity = buttonCapacity;
        drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
    public int getCount()
    {
        return drinks.size();
    }
    public void addDrink(Drink drink)
    {
        if(drinks.size() < buttonCapacity)
        {
            drinks.add(drink);
        }
    }
    public boolean removeDrink(String name)
    {
        for(int i = 0; i < drinks.size(); i++)
        {
            if(drinks.get(i).getName().equals(name))
            {
                drinks.remove(i);
                return true;
            }
        }
        return false;
    }
    public Drink getLongest()
    {
        return drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }
    public Drink getCheapest()
    {
        return drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }
    public String buyDrink(String name)
    {
        Optional<Drink> drink = drinks.stream().filter(n -> n.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Drinks available:%n"));
        for(Drink drink : drinks)
        {
            sb.append(drink.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
