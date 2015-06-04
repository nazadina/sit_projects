package bsuir.model.dao.implement;

import java.util.List;
import bsuir.model.dao.AcceptOrderDao;
import bsuir.model.pojo.AcceptOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcceptOrderDaoImpl implements AcceptOrderDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(AcceptOrder acceptOrder) {
        session.getCurrentSession().save(acceptOrder);
    }

    @Override
    public void edit(AcceptOrder acceptOrder) {
        session.getCurrentSession().update(acceptOrder);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getAcceptOrder(id));
    }

    @Override
    public AcceptOrder getAcceptOrder(int id) {
        return (AcceptOrder) session.getCurrentSession().get(AcceptOrder.class, id);
    }

    @Override
    public List getAllAcceptOrder() {
        return session.getCurrentSession().createQuery("from AcceptOrder").list();
    }

}
