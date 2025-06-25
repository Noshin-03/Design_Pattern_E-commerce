package noshin03.ecommarce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Update path to match your seeded database
                connection = DriverManager.getConnection("jdbc:sqlite:dp.db");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

