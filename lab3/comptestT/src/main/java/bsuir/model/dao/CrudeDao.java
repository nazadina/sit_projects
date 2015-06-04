package bsuir.model.dao;

import bsuir.model.pojo.Crude;
import java.util.List;

public interface CrudeDao {

    public void add(Crude crude);

    public void edit(Crude crude);

    public void delete(int id);

    public Crude getCrude(int id);

    public List getAllCrude();
}
