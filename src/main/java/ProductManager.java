public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.showAllProducts()) {
            if (matches(product, text)) {
                Product[] tmpresult = new Product[1];
                tmpresult[0] = product;
                result = tmpresult;


            }
        }

        return result;
    }
}
