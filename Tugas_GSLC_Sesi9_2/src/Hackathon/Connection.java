package Hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Connection {
    private String fileName;

    public Connection(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String[]> readData() {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void writeData(ArrayList<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
    // Facade Pattern yang kami gunakan untuk melakukan proses query dari dan ke file-file .csv
    public ArrayList<String[]> executeQuery(String query) {
        if (query.equals("SELECT * FROM data")) {
            return readData();
        } else if (query.startsWith("INSERT INTO data")) {
            return insertData(query);
        } else {
            return null;
        }
    }

  
    private ArrayList<String[]> insertData(String query) {
        String[] values = query.split("VALUES")[1].trim().replaceAll("[()]", "").split(",");
        ArrayList<String[]> data = readData();
        data.add(values);
        writeData(data);
        return data;
    }
}