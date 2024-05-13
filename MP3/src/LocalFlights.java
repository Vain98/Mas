public class LocalFlights extends Flights{
        //Disjoint classes
    private Boolean WifiExist;
    private Boolean SnackService;

    public LocalFlights(String flightNumber, String departureAirport, String arrivalAirport, Boolean wifiExist, Boolean snackService,FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport,fuelType);
        this.WifiExist = wifiExist;
        this.SnackService = snackService;
    }

    public Boolean getWifiExist() {
        return WifiExist;
    }

    public void setWifiExist(Boolean wifiExist) {
        WifiExist = wifiExist;
    }

    public Boolean getSnackService() {
        return SnackService;
    }

    public void setSnackService(Boolean snackService) {
        SnackService = snackService;
    }
        //Polymorphic method
    public void DisplayFlightDetails(){
        System.out.println("Here is the local flight details");
    }



}
