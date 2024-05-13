public class CoPilot{
    private String trainingRecords;


    public CoPilot(String trainingRecords) {
        this.trainingRecords = trainingRecords;
    }

    public String getTrainingRecords() {
        return trainingRecords;
    }

    public void setTrainingRecords(String trainingRecords) {
        this.trainingRecords = trainingRecords;
    }

    @Override
    public String toString() {
        return "CoPilot{" +
                "trainingRecords='" + trainingRecords + '\'' +
                "} " + super.toString();
    }
}
