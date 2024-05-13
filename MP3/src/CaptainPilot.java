public class CaptainPilot {
    private String rank;

    public CaptainPilot(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "CaptainPilot{" +
                "rank='" + rank + '\'' +
                "} " + super.toString();
    }
}
