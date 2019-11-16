package ku.shop;

public class NotEnoughInventoryException extends Exception {
    public NotEnoughInventoryException() {}
    public NotEnoughInventoryException(String reason) {
        super(reason);
    }
}