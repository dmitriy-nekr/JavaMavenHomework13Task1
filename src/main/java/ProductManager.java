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
        int counter = 0;
        for (Product product : repo.showAllProducts()) {
            if (matches(product, text)) {
                if (counter == 0) {
                    Product[] tmpresult = new Product[counter + 1];
                    tmpresult[counter] = product;
                    result = tmpresult;

                }
                if (counter > 0) {
                    Product[] tmpresult1 = new Product[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmpresult1[i] = result[i];
                    }
                    tmpresult1[tmpresult1.length - 1] = product;
                    result = tmpresult1;

                }
                counter++;

            }
        }
        return result;
    }
}



