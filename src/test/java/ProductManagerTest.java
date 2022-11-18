import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Product(5, "a", 500);
    Product product2 = new Product(4, "b", 400);
    Product product3 = new Product(3, "c", 300);
    Product product4 = new Book(6, "Book1", 700, "Petya");
    Product product5 = new Smartphone(7, "Smartphone1", 1200, "Samsung");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

    }


    @Test
    public void shouldSearchByName() {
        Product[] actual = manager.searchBy("b");
        Product[] expected = {product2};
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldAdd(){
        Product[]expected= {product1, product2,product3,product4,product5};
        Product[]actual= repo.showAllProducts();
        Assertions.assertArrayEquals(expected,actual);
    }
}
