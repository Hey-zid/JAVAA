public class Meter {
    private String customerId;
    private String meterNumber;
    private int previousReading;
    private int currentReading;

    // Constructor - used to create a new Meter object
    public Meter(String customerId, String meterNumber, int previousReading, int currentReading) {
        this.customerId = customerId;
        this.meterNumber = meterNumber;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public int getPreviousReading() {
        return previousReading;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    // Calculates units used instead of storing it separately
    public int getUnitsUsed() {
        return currentReading - previousReading;
    }
}