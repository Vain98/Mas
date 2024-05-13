public class InternationalFlight extends Flights{

    //Disjoint classes
    private Boolean PassaportControl;
    private String VisaRequirements;


    public InternationalFlight(String flightNumber, String departureAirport, String arrivalAirport, Boolean passaportControl,FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport,fuelType);
        this.PassaportControl = passaportControl;
    }

    public Boolean getPassaportControl() {
        return PassaportControl;
    }

    public void setPassaportControl(Boolean passaportControl) {
        PassaportControl = passaportControl;
    }

    public String getVisaRequirements() {
        return VisaRequirements;
    }

    public void setVisaRequirements(String visaRequirements) {
        VisaRequirements = visaRequirements;
    }
    //Polymorphic method
    public void DisplayFlightDetails(){
        System.out.println("Here is the International flight details");
    }
}
