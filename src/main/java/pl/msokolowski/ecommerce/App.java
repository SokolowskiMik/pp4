package pl.msokolowski.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.msokolowski.ecommerce.catalog.ArrayListProductStorage;
import pl.msokolowski.ecommerce.catalog.ProductCatalog;
import pl.msokolowski.ecommerce.sales.SalesFacade;
import pl.msokolowski.ecommerce.sales.cart.HashMapCartStorage;
import pl.msokolowski.ecommerce.sales.offering.OfferCalculator;
import pl.msokolowski.ecommerce.sales.payment.PaymentDetails;
import pl.msokolowski.ecommerce.sales.payment.PaymentGateway;
import pl.msokolowski.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.msokolowski.ecommerce.sales.reservation.ReservationRepository;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Here we go!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Lego set 1", "nice one");
        productCatalog.addProduct("Lego set 2", "nice one");
        productCatalog.addProduct("Lego set 3", "nice one");

        return productCatalog;
    }

    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                new PaymentGateway() {
                    @Override
                    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
                        return null;
                    }
                },
                new ReservationRepository()
        );
    }
}
