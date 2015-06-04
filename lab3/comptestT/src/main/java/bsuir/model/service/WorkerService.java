package bsuir.model.service;

import bsuir.model.pojo.Worker;
import java.util.List;

public interface WorkerService {

    public void add(Worker worker);

    public void edit(Worker worker);

    public void delete(int id);

    public Worker getWorker(int id);

    public List getAllWorker();
}
