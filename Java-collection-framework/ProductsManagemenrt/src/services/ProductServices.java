package services;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServices implements IProductServices {
    public static List<Product> productList = new ArrayList<Product>();

    public ProductServices() {
        productList.add(new Product(1000,"OMO", 50, 10000));
        productList.add(new Product(1001,"P/S", 30, 30000));
        productList.add(new Product(1000,"OMO", 50, 16000));
        productList.add(new Product(1002,"OISHI", 20, 60000));
        productList.add(new Product(1000,"OMO", 10, 15000));
        productList.add(new Product(1003,"LAVIEOM", 70, 90000));
        productList.add(new Product(1000,"OMO", 99, 15000));
        productList.add(new Product(1004,"AQUAFINA", 25, 70000));

    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public void addProduct(Product newProduct) {
        productList.add(newProduct);
    }

    @Override
    public Product getByProductId(long productId) {
        for (Product product : getProducts()) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean existById(long productId) {
        return getByProductId(productId) != null;
    }

    @Override
    public void update(Product newProduct) {
        Product product = getByProductId(newProduct.getProductId());
        product.setName(newProduct.getName());
    }

    @Override
    public void removeById(long productId) {

    }
}
