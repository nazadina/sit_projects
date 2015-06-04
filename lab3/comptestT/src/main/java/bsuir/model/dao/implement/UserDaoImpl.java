package bsuir.model.dao.implement;

import bsuir.model.dao.UserDao;
import bsuir.model.pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(User user) {
        session.getCurrentSession().save(user);
    }

    @Override
    public void edit(User user) {
        session.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUser(id));
    }

    @Override
    public User getUser(int id) {
        return (User) session.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getLogin(String login) {
        Criteria criteria = session.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUser() {
        return session.getCurrentSession().createQuery("from User").list();
    }

}
