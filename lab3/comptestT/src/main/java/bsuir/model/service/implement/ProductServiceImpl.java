package bsuir.model.service.implement;

import bsuir.model.dao.ProductDao;
import bsuir.model.pojo.Product;
import bsuir.model.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void add(Product product) {
        productDao.add(product);
    }

    @Transactional
    public void edit(Product product) {
        productDao.edit(product);
    }

    @Transactional
    public void delete(int id) {
        productDao.delete(id);
    }

    @Transactional
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    @Transactional
    public List getAllProduct() {
        return productDao.getAllProduct();
    }
}
