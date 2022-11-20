import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Product(5, "a", 500);
    Product product2 = new Product(4, "b", 400);
    Product product3 = new Product(3, "c", 300);
    Product product4 = new Book(6, "d", 700, "Petya");
    Product product5 = new Smartphone(7, "e", 1200, "Samsung");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

    }


    @Test
    public void shouldSearchByOneName() {
        Product[] actual = manager.searchBy("c");
        Product[] expected = {product3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAboveOneName() {
        Product product6 = new Product(8, "b", 250);
        manager.add(product6);
        Product[] actual = manager.searchBy("b");
        Product[] expected = {product2, product6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNotExistedName() {
        Product[] actual = manager.searchBy("g");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldAdd() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.showAllProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
}
