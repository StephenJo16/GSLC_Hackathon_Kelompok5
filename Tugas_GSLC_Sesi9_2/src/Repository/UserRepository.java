package Repository;
import Models.User;
import java.util.ArrayList;

public class UserRepository implements Repository {
    private User user;

    public UserRepository(User user) {
        this.user = user;
    }

    public ArrayList<String[]> find(String column, String[] condition, boolean joinTable, String tableName) {
        return user.find(column, condition, joinTable, tableName);
    }

    public String[] findOne(String column, String[] condition, boolean joinTable, String tableName) {
        return user.findOne(column, condition, joinTable, tableName);
    }

    public String[] insert(String[] userData) {
        return user.insert(userData);
    }
}