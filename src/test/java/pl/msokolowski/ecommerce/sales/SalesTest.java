package pl.msokolowski.ecommerce.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SalesTest {
    @Test
    void itShowsOffer() {
        SalesFacade sales = thereIsSalesFacade();
        String customerId = thereIsExampleCustomer("Mikolaj");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private String thereIsExampleCustomer(String id) {
        return id;
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    @Test
    void itAllowsToAddProductToCart() {

    }

    @Test
    void itAllowsToRemoveProductFromCart() {

    }

    @Test
    void itAllowsToAcceptOffer() {

    }
}
