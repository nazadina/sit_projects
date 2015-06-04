package bsuir.model.dao;

import bsuir.model.pojo.ConfEnterprise;
import java.util.List;

public interface ConfEnterpriseDao {

    public void add(ConfEnterprise confEnterprise);

    public void edit(ConfEnterprise confEnterprise);

    public void delete(int id);

    public ConfEnterprise getConfEnterprise(int id);

    public List getAllConfEnterprise();
}
