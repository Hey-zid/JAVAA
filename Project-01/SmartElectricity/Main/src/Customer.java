public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String meterNumber;

    // Constructor - used to create a new Customer object
    public Customer(String customerId, String name, String address, String meterNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.meterNumber = meterNumber;
    }

    // Getters - allow other classes to read the data
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    // Setters - allow updating data (but NOT customerId, which stays fixed)
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }
}