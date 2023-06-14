package DatabaseServices;

import java.sql.*;
import java.util.function.Consumer;

public class ExecuteSql {
    public void QueExecute (String sql, Consumer<ResultSet> consumer) {
        Database database = Database.getInstance();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            consumer.accept(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
