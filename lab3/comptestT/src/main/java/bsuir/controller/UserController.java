package bsuir.controller;

import bsuir.model.pojo.User;
import bsuir.model.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/user")
    public String setupForm(Map<String, Object> map) {
        User user = new User();
        map.put("user", user);
        map.put("userList", userService.getAllUser());
        return "user";
    }

    @RequestMapping(value = "/user.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute User user, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {
        User userResult = new User();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == user.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                userService.add(user);
                userResult = user;
                System.out.println(userResult.toString());
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    userService.edit(user);
                    userResult = user;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    userService.delete(user.getId());
                    userResult = new User();
                    break;
                }
            case "search":
                User searchUser = userService.getUser(user.getId());
                userResult = searchUser != null ? searchUser : new User();
                break;
        }
        map.put("user", userResult);
        map.put("userList", userService.getAllUser());
        return "user";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        List lst = session.createQuery("select id from User").list();
        return lst;
    }
}
