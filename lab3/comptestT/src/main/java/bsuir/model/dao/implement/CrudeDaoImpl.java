package bsuir.model.dao.implement;

import bsuir.model.dao.CrudeDao;
import bsuir.model.pojo.Crude;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrudeDaoImpl implements CrudeDao{
    @Autowired
    private SessionFactory session;

    @Override
    public void add(Crude crude) {
        session.getCurrentSession().save(crude);
    }

    @Override
    public void edit(Crude crude) {
        session.getCurrentSession().update(crude);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getCrude(id));
    }

    @Override
    public Crude getCrude(int id) {
        return (Crude) session.getCurrentSession().get(Crude.class, id);
    }

    @Override
    public List getAllCrude() {
        return session.getCurrentSession().createQuery("from Crude").list();
    }
    
}
