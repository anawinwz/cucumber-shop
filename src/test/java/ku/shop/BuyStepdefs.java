package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price, 999999);
    }

    @Given("a product (.+) with price (.+) and quantity (.+) exists")
    public void a_product_with_price_quantity_exists(String name, double price, int quant) {
        catalog.addProduct(name, price, quant);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) throws NotEnoughInventoryException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
    
    @When("a customer buy (.+) with quantity (.+)")
    public void customer_buy_with_quantity(String name, int quant) throws NotEnoughInventoryException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("quantity of (.+) should be (.+)")
    public void quantity_should_be(String name, int quant) {
        Product prod = catalog.getProduct(name);
        assertEquals(quant, prod.getQuantity());
    }
}

