package NetworkHelper;

public class Address {
    private final String ipAddress;
    private final String macAddress;
    public Address(String ipAddress, String macAddress) {
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }
    // More maybe to be added later?
}
