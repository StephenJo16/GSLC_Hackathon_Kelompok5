package Models;
import Hackathon.CSVFacade;
import java.util.ArrayList;
import java.util.Arrays;


public class User extends Model {
    public User(CSVFacade facade) {
        super(facade);
    }

    public ArrayList<String[]> find(String column, String[] condition, boolean joinTable, String tableName) {
        ArrayList<String[]> result = new ArrayList<>();

        for (String[] row : data) {
            boolean satisfiesCondition = true;

            if (condition != null) {
                for (int i = 0; i < condition.length; i += 3) {
                    String filterColumn = condition[i];
                    String operator = condition[i + 1];
                    String filterValue = condition[i + 2];

                    int columnIndex = Arrays.asList(row).indexOf(filterColumn);
                    if (columnIndex != -1) {
                        switch (operator) {
                            case "=":
                                satisfiesCondition &= row[columnIndex].equals(filterValue);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            if (satisfiesCondition) {
                result.add(row);
            }
        }

        return result;
    }

    public String[] findOne(String column, String[] condition, boolean joinTable, String tableName) {
        ArrayList<String[]> result = find(column, condition, joinTable, tableName);
        return result.isEmpty() ? null : result.get(0);
    }

    public String[] insert(String[] userData) {
        int id = data.size() + 1;
        String[] newRow = Arrays.copyOf(userData, userData.length + 1);
        newRow[newRow.length - 1] = String.valueOf(id);
        data.add(newRow);
        save();
        return newRow;
    }
}