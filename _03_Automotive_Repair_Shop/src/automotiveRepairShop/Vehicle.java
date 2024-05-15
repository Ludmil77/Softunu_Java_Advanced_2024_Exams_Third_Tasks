package automotiveRepairShop;

public class Vehicle
{
    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String vin, int mileage, String damage) {
        VIN = vin;
        this.mileage = mileage;
        this.damage = damage;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
    public String toString()
    {
        return String.format("Damage: %s, Vehicle: %s (%d km)", damage, VIN, mileage);
    }
}
