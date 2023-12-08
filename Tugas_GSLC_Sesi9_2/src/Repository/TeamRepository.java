package Repository;
import Models.Team;
import java.util.ArrayList;


public class TeamRepository implements Repository {
    private Team team;

    public TeamRepository(Team team) {
        this.team = team;
    }

    public ArrayList<String[]> find(String column, String[] condition, boolean joinTable, String tableName) {
        return team.find(column, condition, joinTable, tableName);
    }

    public String[] findOne(String column, String[] condition, boolean joinTable, String tableName) {
        return team.findOne(column, condition, joinTable, tableName);
    }

    public String[] insert(String[] teamData) {
        return team.insert(teamData);
    }
}