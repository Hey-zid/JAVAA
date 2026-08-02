// Topic 5: Constructors with Encapsulation
// Topic 6: Passing Objects as an Array and Operations using Getter/Setter

class Item {

    // Private data members
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter method
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate total price
    public double getTotalPrice() {
        return price * quantity;
    }

    // Display item information
    public void displayItem() {
        System.out.println(
                id + " | " +
                name + " | " +
                price + " | " +
                quantity + " | " +
                getTotalPrice()
        );
    }
}



