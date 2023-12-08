package Hackathon;
import java.util.ArrayList;

public class CSVFacade {
    private Connection connection;

    public CSVFacade(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<String[]> fetchData() {
        return connection.readData();
    }

    public void saveData(ArrayList<String[]> data) {
        connection.writeData(data);
    }
}