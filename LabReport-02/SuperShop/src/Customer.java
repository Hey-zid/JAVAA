// Topic 3: Getter and Setter Methods
// Topic 4: Use of this Keyword

class Customer {

    // Private data members
    private String name;
    private String phone;
    private double purchase;

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getPurchase() {
        return purchase;
    }

    // Display customer information
    public void displayCustomer() {
        System.out.println("Customer Name : " + getName());
        System.out.println("Phone Number  : " + getPhone());
        System.out.println("Purchase      : " + getPurchase());
    }
}