public class LocalFlights {
    private String terminalInfo;


    public LocalFlights(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    @Override
    public String toString() {
        return "LocalFlight{terminalInfo='" + terminalInfo + "'}";
    }
}
