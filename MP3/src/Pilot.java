public class Pilot {
    private String firstName;
    private String lastName;
    private int yearsOfExperience;

    private CaptainPilot captainType;
    private CoPilot coPilotType;

    public Pilot(String firstName, String lastName, int yearsOfExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
    }

    //constructor for Captain type
    public Pilot(String firstName, String lastName, int yearsOfExperience, CaptainPilot captainType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        setCaptainType(captainType);
    }

    //constructor for Co-Pilot type
    public Pilot(String firstName, String lastName, int yearsOfExperience, CoPilot coPilotType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        setCoPilotType(coPilotType);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public CaptainPilot getCaptainType() {
        return captainType;
    }

    public void setCaptainType(CaptainPilot captainType) {
        if (this.coPilotType != null){
            this.coPilotType = null;
        }
        this.captainType = captainType;
    }

    public CoPilot getCoPilotType() {
        return coPilotType;
    }

    public void setCoPilotType(CoPilot coPilotType) {
        if (this.captainType != null){
            this.captainType = null;
        }
        this.coPilotType = coPilotType;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", captainType=" + captainType +
                ", coPilotType=" + coPilotType +
                '}';
    }
}
