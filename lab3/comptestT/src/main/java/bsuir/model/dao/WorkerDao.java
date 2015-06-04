package bsuir.model.dao;

import bsuir.model.pojo.Worker;
import java.util.List;

public interface WorkerDao {

    public void add(Worker worker);

    public void edit(Worker worker);

    public void delete(int id);

    public Worker getWorker(int id);

    public List getAllWorker();
}
