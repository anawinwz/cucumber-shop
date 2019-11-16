package ku.shop;

public class OrderItem {
    private int quantity;
    private Product prod;

    public OrderItem(Product prod, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("OrderItem quantity must be positive");
        
        if (prod.getQuantity() < quantity)
            throw new NotEnoughInventoryException("Not enough quantity to order");    

        this.prod = prod;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return prod.getPrice() * quantity;
    }

}
