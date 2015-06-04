package bsuir.controller;

import bsuir.model.pojo.ConfEnterprise;
import bsuir.model.service.ConfEnterpriseService;
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
public class ConfEnterpriseController {

    @Autowired
    private ConfEnterpriseService confEnterpriseService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/ConfEnterprise")
    public String setupForm(Map<String, Object> map) {
        ConfEnterprise confEnterprise = new ConfEnterprise();
        map.put("confEnterprise", confEnterprise);
        map.put("confEnterpriseList", confEnterpriseService.getAllConfEnterprise());
        return "confEnterprise";
    }

    @RequestMapping(value = "/ConfEnterprise.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute ConfEnterprise confEnterprise, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {
        ConfEnterprise confEnterpriseResult = new ConfEnterprise();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == confEnterprise.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                confEnterpriseService.add(confEnterprise);
                confEnterpriseResult = confEnterprise;
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    confEnterpriseService.edit(confEnterprise);
                    confEnterpriseResult = confEnterprise;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    confEnterpriseService.delete(confEnterprise.getId());
                    confEnterpriseResult = new ConfEnterprise();
                    break;
                }
            case "search":
                ConfEnterprise searchConfEnterprise = confEnterpriseService.getConfEnterprise(confEnterprise.getId());
                confEnterpriseResult = searchConfEnterprise != null ? searchConfEnterprise : new ConfEnterprise();
                break;
        }
        map.put("confEnterprise", confEnterpriseResult);
        map.put("confEnterpriseList", confEnterpriseService.getAllConfEnterprise());
        return "confEnterprise";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        List lst = session.createQuery("select id from ConfEnterprise").list();
        return lst;
    }
}
