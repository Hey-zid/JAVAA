// Topic 1: Encapsulation and Data Hiding
// Topic 2: Private Data Members

class Product {

    // Private data members
    private String productName;
    private int productId;
    private double price;

    // Method to set product information
    public void setProduct(String name, int id, double price) {
        productName = name;
        productId = id;
        this.price = price;
    }

    // Method to display product information
    public void displayProduct() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }
}