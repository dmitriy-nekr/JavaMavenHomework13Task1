import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositiryTest {
    ProductRepository repo = new ProductRepository();
    Product product1 = new Product(5, "a", 500);
    Product product2 = new Product(4, "b", 400);
    Product product3 = new Product(3, "c", 300);
    Product product4 = new Book(6, "Book1", 700, "Petya");
    Product product5 = new Smartphone(7, "Smartphone1", 1200, "Samsung");

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
    }

    @Test
    public void shouldSave() {

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.showAllProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {

        repo.removeById(5);
        Product[] expected = {product2, product3, product4, product5};
        Product[] actual = repo.showAllProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
}