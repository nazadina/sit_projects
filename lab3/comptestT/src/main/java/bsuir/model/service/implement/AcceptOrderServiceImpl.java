package bsuir.model.service.implement;

import java.util.List;
import bsuir.model.dao.AcceptOrderDao;
import bsuir.model.pojo.AcceptOrder;
import bsuir.model.service.AcceptOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcceptOrderServiceImpl implements AcceptOrderService {

    @Autowired
    private AcceptOrderDao acceptOrderDao;

    @Transactional
    public void add(AcceptOrder acceptOrder) {
        acceptOrderDao.add(acceptOrder);
    }

    @Transactional
    public void edit(AcceptOrder acceptOrder) {
        acceptOrderDao.edit(acceptOrder);
    }

    @Transactional
    public void delete(int id) {
        acceptOrderDao.delete(id);
    }

    @Transactional
    public AcceptOrder getAcceptOrder(int id) {
        return acceptOrderDao.getAcceptOrder(id);
    }

    @Transactional
    public List getAllAcceptOrder() {
        return acceptOrderDao.getAllAcceptOrder();
    }

}
