package bsuir.controller;

import bsuir.model.pojo.Crude;
import bsuir.model.service.CrudeService;
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
public class CrudeController {

    @Autowired
    private CrudeService crudeService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/Crude")
    public String setupForm(Map<String, Object> map) {
        Crude crude = new Crude();
        map.put("crude", crude);
        map.put("crudeList", crudeService.getAllCrude());
        return "crude";
    }

    @RequestMapping(value = "/Crude.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Crude crude, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {
        Crude crudeResult = new Crude();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == crude.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                crudeService.add(crude);
                crudeResult = crude;
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    crudeService.edit(crude);
                    crudeResult = crude;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    crudeService.delete(crude.getId());
                    crudeResult = new Crude();
                    break;
                }
            case "search":
                Crude searchCrude = crudeService.getCrude(crude.getId());
                crudeResult = searchCrude != null ? searchCrude : new Crude();
                break;
        }
        map.put("crude", crudeResult);
        map.put("crudeList", crudeService.getAllCrude());
        return "crude";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        List lst = session.createQuery("select id from Crude").list();
        return lst;
    }
}
