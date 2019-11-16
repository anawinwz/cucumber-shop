package ku.shop;

public class Product {
    private double price;
    private String name;
    private int quantity;

    public Product(String name, double price, int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity must be not be negative zero");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }
    public void addStock(int quantity) {
        this.quantity = this.quantity + quantity;
    }
    public void removeStock(int quantity) {
        if (this.quantity < quantity)
            throw new NotEnoughInventoryException("Quantity after removing must not be negative zero");
        this.quantity = this.quantity - quantity;
    }
}
