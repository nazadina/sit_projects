package bsuir.model.dao;

import bsuir.model.pojo.Product;
import java.util.List;

public interface ProductDao {

    public void add(Product product);

    public void edit(Product product);

    public void delete(int id);

    public Product getProduct(int id);

    public List getAllProduct();
}
