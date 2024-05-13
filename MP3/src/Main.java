public class Main {
    public static void main(String[] args) {

        ElectricSupplied electric=new ElectricSupplied(100,"16 hours");
        //Testing abstract class

        TestFlight testingAbstractclass=new TestFlight("TK1567","FR","TR",electric);
        testingAbstractclass.DisplayFlightDetails();
        System.out.println("--------------------");

        //Testing polymorphic method call
        Flights myFlight = new InternationalFlight("TK1223","Poland","France",Boolean.TRUE,electric);//Disjoint class test
        myFlight.DisplayFlightDetails();
        System.out.println("--------------------");

        Flights myFlight1=new LocalFlights("TK2222","Krakow","Warsaw",Boolean.FALSE,Boolean.TRUE,electric);//Disjoint class test
        myFlight1.DisplayFlightDetails();
        System.out.println("--------------------");

        //Testing Overlapping inheritances
        CargoFlight mycargoFlight=new CargoFlight("TK111","Warsaw","Gdansk",1200,electric);
        mycargoFlight.setCargoReady(true);
        mycargoFlight.handleCargo();
        mycargoFlight.DisplayFlightDetails();
        System.out.println("--------------------");

        MedicalFlight mymedicalFlight=new MedicalFlight("AS2222","Gdansk","Warsaw",electric);
        mymedicalFlight.handleEmergency();
        System.out.println("--------------------");

        CharterFlight mycharterFlight=new CharterFlight("TK1134","Krakow","Paris",electric);
        mycharterFlight.handleCharter();
        System.out.println("--------------------");

        //Testing For multi inheritance
        AmphibiousPlane myAmphibiousPlane=new AmphibiousPlane();
        myAmphibiousPlane.FlotOnWater();
        myAmphibiousPlane.LandOnWater();
        myAmphibiousPlane.NavigateOnWater();
        myAmphibiousPlane.TakeOffFromWater();
        System.out.println("--------------------");

        //Testing multi aspect
        GasSupplied gasSupplied = new GasSupplied(100, "12.9");
        CargoFlight cargoFlight = new CargoFlight("TK112","Warsaw","Gdansk",1200,electric);
        CharterFlight charterFlight = new CharterFlight("TK1134","Baku","Paris",gasSupplied);
        cargoFlight.DisplayFlightDetails();
        charterFlight.DisplayFlightDetails();
        System.out.println("--------------------");

        //Dynamic
        CoPilot coPilot = new CoPilot("3 years");
        CaptainPilot captainPilot = new CaptainPilot("Captain");
        Pilot pilot = new Pilot("Cem", "Gonul", 10, coPilot);
        System.out.println(pilot);
        pilot.setCaptainType(captainPilot);
        System.out.println(pilot);


    }
}