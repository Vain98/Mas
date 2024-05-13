public abstract class FuelType{
    private Integer FuelCapacity;


    public FuelType(Integer fuelCapacity) {
        FuelCapacity = fuelCapacity;
    }

    public Integer getFuelCapacity() {
        return FuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        FuelCapacity = fuelCapacity;
    }
}