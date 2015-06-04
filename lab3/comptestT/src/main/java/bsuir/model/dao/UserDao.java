package bsuir.model.dao;

import bsuir.model.pojo.User;
import java.util.List;

public interface UserDao {

    public void add(User user);

    public void edit(User user);

    public void delete(int id);

    public User getUser(int id);
    
    public User getLogin(String login);

    public List<User> getAllUser();
}
