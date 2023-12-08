// Repository interface class
package Repository;

import java.util.ArrayList;

interface Repository {
    ArrayList<String[]> find(String column, String[] condition, boolean joinTable, String tableName);

    String[] findOne(String column, String[] condition, boolean joinTable, String tableName);

    String[] insert(String[] data);
}