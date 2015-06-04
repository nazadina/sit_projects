package bsuir.model.service.implement;

import bsuir.model.dao.ConfEnterpriseDao;
import bsuir.model.pojo.ConfEnterprise;
import bsuir.model.service.ConfEnterpriseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfEnterpriseServiceImpl implements ConfEnterpriseService {

    @Autowired
    private ConfEnterpriseDao confEnterpriseDao;

    @Transactional
    public void add(ConfEnterprise confEnterprise) {
        confEnterpriseDao.add(confEnterprise);
    }

    @Transactional
    public void edit(ConfEnterprise confEnterprise) {
        confEnterpriseDao.edit(confEnterprise);
    }

    @Transactional
    public void delete(int id) {
        confEnterpriseDao.delete(id);
    }

    @Transactional
    public ConfEnterprise getConfEnterprise(int id) {
        return confEnterpriseDao.getConfEnterprise(id);
    }

    @Transactional
    public List getAllConfEnterprise() {
        return confEnterpriseDao.getAllConfEnterprise();
    }
}
