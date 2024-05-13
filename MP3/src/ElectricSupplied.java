public class ElectricSupplied extends FuelType{
    private String ChargingTime;

    public ElectricSupplied(Integer fuelCapacity, String chargingTime) {
        super(fuelCapacity);
        ChargingTime = chargingTime;
    }

    public String getChargingTime() {
        return ChargingTime;
    }

    public void setChargingTime(String chargingTime) {
        ChargingTime = chargingTime;
    }
}
