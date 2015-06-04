package bsuir.model.dao.implement;

import bsuir.model.dao.ProductDao;
import bsuir.model.pojo.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Product product) {
        session.getCurrentSession().save(product);
    }

    @Override
    public void edit(Product product) {
        session.getCurrentSession().update(product);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getProduct(id));
    }

    @Override
    public Product getProduct(int id) {
        return (Product) session.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List getAllProduct() {
        return session.getCurrentSession().createQuery("from Product").list();
    }
}
