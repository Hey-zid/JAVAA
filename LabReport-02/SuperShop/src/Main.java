// Main Program
// Creating objects and calling methods from all three programs

public class Main {

    public static void main(String[] args) {

        //=>Calling Product

        System.out.println("\n=>Product Detail");

        Product p1 = new Product();

        p1.setProduct("Rice", 101, 750.00);

        p1.displayProduct();


        //=>Calling Customer

        System.out.println("\n=>Customer Detail");

        Customer c1 = new Customer();

        c1.setName("Ayon Mia");
        c1.setPhone("01700000000");
        c1.setPurchase(2500.00);

        c1.displayCustomer();



        //=>Calling Item


        System.out.println("\n=>Item Detail");

        // Creating objects using constructor
        Item item1 = new Item(101, "Rice", 750.00, 5);
        Item item2 = new Item(102, "Oil", 180.00, 10);
        Item item3 = new Item(103, "Sugar", 120.00, 8);

        // Passing objects as an array
        Item[] items = {item1, item2, item3};

        System.out.println("ID | Name | Price | Quantity | Total");
        System.out.println("------------------------------------");

        // Display all items
        for (Item item : items) {
            item.displayItem();
        }

        // Calculate total inventory value
        double total = 0;

        for (Item item : items) {
            total = total + item.getTotalPrice();
        }

        System.out.println("\nTotal Inventory Value: " + total + "\n");


        // Updating quantity using setter
        item2.setQuantity(15);

        System.out.println(
                "\nUpdated Oil Quantity: "
                        + item2.getQuantity()
        );

        System.out.println(
                "Updated Oil Total: "
                        + item2.getTotalPrice()
        );
    }
}