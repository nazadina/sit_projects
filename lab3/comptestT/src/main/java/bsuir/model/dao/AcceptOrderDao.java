package bsuir.model.dao;

import java.util.List;
import bsuir.model.pojo.AcceptOrder;

public interface AcceptOrderDao {

    public void add(AcceptOrder acceptOrder);

    public void edit(AcceptOrder acceptOrder);

    public void delete(int id);

    public AcceptOrder getAcceptOrder(int id);

    public List getAllAcceptOrder();

}
