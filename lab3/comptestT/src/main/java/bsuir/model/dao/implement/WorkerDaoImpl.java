package bsuir.model.dao.implement;

import bsuir.model.dao.WorkerDao;
import bsuir.model.pojo.Worker;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerDaoImpl implements WorkerDao{
    
    @Autowired
    private SessionFactory session;
    
    @Override
    public void add(Worker worker) {
        session.getCurrentSession().save(worker);
    }

    @Override
    public void edit(Worker worker) {
        session.getCurrentSession().update(worker);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getWorker(id));
    }

    @Override
    public Worker getWorker(int id) {
        return (Worker) session.getCurrentSession().get(Worker.class, id);
    }

    @Override
    public List getAllWorker() {
        return session.getCurrentSession().createQuery("from Worker").list();
    }
}
