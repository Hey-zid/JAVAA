public class Bill {
    private String customerId;
    private String month;
    private int unitsUsed;
    private int reading;
    private String status; // "Paid" or "Unpaid"

    // Constructor - used to create a new Bill object
    public Bill(String customerId, String month, int unitsUsed, int reading, String status) {
        this.customerId = customerId;
        this.month = month;
        this.unitsUsed = unitsUsed;
        this.reading = reading;
        this.status = status;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getMonth() {
        return month;
    }

    public int getUnitsUsed() {
        return unitsUsed;
    }

    public int getReading() {
        return reading;
    }

    public String getStatus() {
        return status;
    }

    // Setter - only status is allowed to change after creation
    public void setStatus(String status) {
        this.status = status;
    }
}