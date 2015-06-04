package bsuir.controller;

import bsuir.model.pojo.Worker;
import bsuir.model.service.WorkerService;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/worker")
    public String setupForm(Map<String, Object> map) {
        Worker worker = new Worker();
        map.put("worker", worker);
        map.put("workerList", workerService.getAllWorker());
        return "worker";
    }

    @RequestMapping(value = "/worker.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Worker worker, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {
        Worker workerResult = new Worker();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == worker.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                workerService.add(worker);
                workerResult = worker;
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    workerService.edit(worker);
                    workerResult = worker;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    workerService.delete(worker.getId());
                    workerResult = new Worker();
                    break;
                }
            case "search":
                Worker searchWorker = workerService.getWorker(worker.getId());
                workerResult = searchWorker != null ? searchWorker : new Worker();
                break;
        }
        map.put("worker", workerResult);
        map.put("workerList", workerService.getAllWorker());
        return "worker";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        List lst = session.createQuery("select id from AcceptOrder").list();
        return lst;
    }
}
