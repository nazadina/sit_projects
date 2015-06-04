package bsuir.model.dao.implement;

import bsuir.model.dao.ConfEnterpriseDao;
import bsuir.model.pojo.ConfEnterprise;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConfEnterpriseDaoImpl implements ConfEnterpriseDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(ConfEnterprise confEnterprise) {
        session.getCurrentSession().save(confEnterprise);
    }

    @Override
    public void edit(ConfEnterprise confEnterprise) {
        session.getCurrentSession().update(confEnterprise);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getConfEnterprise(id));
    }

    @Override
    public ConfEnterprise getConfEnterprise(int id) {
        return (ConfEnterprise) session.getCurrentSession().get(ConfEnterprise.class, id);
    }

    @Override
    public List getAllConfEnterprise() {
        return session.getCurrentSession().createQuery("from ConfEnterprise").list();
    }
}
