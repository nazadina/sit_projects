package bsuir.controller;

import bsuir.model.pojo.AcceptOrder;
import bsuir.model.service.AcceptOrderService;
import java.io.UnsupportedEncodingException;
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
public class AcceptOrderController {

    @Autowired
    private AcceptOrderService acceptOrderService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/AcceptOrder")
    public String setupForm(Map<String, Object> map) {
        AcceptOrder acceptOrder = new AcceptOrder();
        map.put("acceptOrder", acceptOrder);
        map.put("acceptOrderList", acceptOrderService.getAllAcceptOrder());
        return "acceptOrder";
    }

    @RequestMapping(value = "/AcceptOrder.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute AcceptOrder acceptOrder, BindingResult result,
            @RequestParam String action, Map<String, Object> map) throws UnsupportedEncodingException {
        AcceptOrder acceptOrderResult = new AcceptOrder();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == acceptOrder.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                acceptOrderService.add(acceptOrder);
                acceptOrderResult = acceptOrder;
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    acceptOrderService.edit(acceptOrder);
                    acceptOrderResult = acceptOrder;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    acceptOrderService.delete(acceptOrder.getId());
                    acceptOrderResult = new AcceptOrder();
                    break;
                }
            case "search":
                AcceptOrder searchAcceptOrder = acceptOrderService.getAcceptOrder(acceptOrder.getId());
                acceptOrderResult = searchAcceptOrder != null ? searchAcceptOrder : new AcceptOrder();
                break;
        }
        map.put("acceptOrder", acceptOrderResult);
        map.put("acceptOrderList", acceptOrderService.getAllAcceptOrder());
        return "acceptOrder";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List lst = session.createQuery("select id from AcceptOrder").list();
        session.getTransaction().commit();
        session.close();
        return lst;
    }

}
