package bsuir.controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculationsController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/calculations", method = RequestMethod.GET)
    public ModelAndView doCalculations() {
        ModelAndView mv = new ModelAndView("calculations");
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(getWorkersSalary()));
        list.add(String.valueOf(getCrudeCost()));
        mv.addObject("list", list);
        return mv;
    }

    public int getWorkersSalary() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List listId = session.createQuery("select id from Worker").list();
        List listE = session.createQuery("select experience from Worker").list();
        List listHWork = session.createQuery("select hoursWork from Worker").list();
        List listHRate = session.createQuery("select hourlyRate from Worker").list();
        List listAward = session.createQuery("select award from Worker").list();
        session.getTransaction().commit();
        session.close();
        int cost = 0;
        for (int i = 0; i < listId.size(); i++) {
            cost += (int) (0.35 * (int) listHRate.get(i) * (int) listHWork.get(i) + 0.35 * (int) listAward.get(i) * (int) listE.get(i) * 0.2);
        }
        return cost;
    }

    public int getCrudeCost() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List listId = session.createQuery("select id from Crude").list();
        List listAmount = session.createQuery("select amount from Crude").list();
        List listCost = session.createQuery("select cost from Crude").list();
        session.getTransaction().commit();
        session.close();
        int cost = 0;
        for (int i = 0; i < listId.size(); i++) {
            cost += (int) listAmount.get(i) * (int) listCost.get(i);
        }
        return cost;
    }
}
