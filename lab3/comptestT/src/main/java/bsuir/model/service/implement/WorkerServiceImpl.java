package bsuir.model.service.implement;

import bsuir.model.dao.WorkerDao;
import bsuir.model.pojo.Worker;
import bsuir.model.service.WorkerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Transactional
    public void add(Worker worker) {
        workerDao.add(worker);
    }

    @Transactional
    public void edit(Worker worker) {
        workerDao.edit(worker);
    }

    @Transactional
    public void delete(int id) {
        workerDao.delete(id);
    }

    @Transactional
    public Worker getWorker(int id) {
        return workerDao.getWorker(id);
    }

    @Transactional
    public List getAllWorker() {
        return workerDao.getAllWorker();
    }
}
