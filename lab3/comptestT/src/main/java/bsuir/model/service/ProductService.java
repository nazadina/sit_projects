package bsuir.model.service;

import bsuir.model.pojo.Product;
import java.util.List;

public interface ProductService {

    public void add(Product product);

    public void edit(Product product);

    public void delete(int id);

    public Product getProduct(int id);

    public List getAllProduct();
}
