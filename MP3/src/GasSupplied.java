public class GasSupplied extends FuelType{
    private String emmisionRate;

    public GasSupplied(Integer fuelCapacity, String emmisionRate) {
        super(fuelCapacity);
        this.emmisionRate = emmisionRate;
    }

    public String getEmmisionRate() {
        return emmisionRate;
    }

    public void setEmmisionRate(String emmisionRate) {
        this.emmisionRate = emmisionRate;
    }
}
