package bsuir.model.service;

import bsuir.model.pojo.ConfEnterprise;
import java.util.List;

public interface ConfEnterpriseService {

    public void add(ConfEnterprise confEnterprise);

    public void edit(ConfEnterprise confEnterprise);

    public void delete(int id);

    public ConfEnterprise getConfEnterprise(int id);

    public List getAllConfEnterprise();
}
