package bsuir.model.service.implement;

import bsuir.model.dao.CrudeDao;
import bsuir.model.pojo.Crude;
import bsuir.model.service.CrudeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudeServiceImpl implements CrudeService {

    @Autowired
    private CrudeDao crudeDao;

    @Transactional
    public void add(Crude crude) {
        crudeDao.add(crude);
    }

    @Transactional
    public void edit(Crude crude) {
        crudeDao.edit(crude);
    }

    @Transactional
    public void delete(int id) {
        crudeDao.delete(id);
    }

    @Transactional
    public Crude getCrude(int id) {
        return crudeDao.getCrude(id);
    }

    @Transactional
    public List getAllCrude() {
        return crudeDao.getAllCrude();
    }

}
