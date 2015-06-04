package bsuir.model.service;

import bsuir.model.pojo.Crude;
import java.util.List;

public interface CrudeService {

    public void add(Crude crude);

    public void edit(Crude crude);

    public void delete(int id);

    public Crude getCrude(int id);

    public List getAllCrude();
}
