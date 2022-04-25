package services;

import model.Product;

import java.util.List;

public interface IProductServices {
    List<Product> getProducts();

    void addProduct(Product newProduct);

    Product getByProductId(long productId);

    boolean existById(long productId);

    void update(Product product);

    void removeById(long productId);
}
