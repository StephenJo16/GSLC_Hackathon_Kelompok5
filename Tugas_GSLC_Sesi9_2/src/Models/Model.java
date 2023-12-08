package Models;
import Hackathon.CSVFacade;
import java.util.ArrayList;

public class Model {
    protected CSVFacade facade;
    protected ArrayList<String[]> data;

    public Model(CSVFacade facade) {
        this.facade = facade;
        this.data = facade.fetchData();
    }

    public void save() {
        facade.saveData(data);
    }
}