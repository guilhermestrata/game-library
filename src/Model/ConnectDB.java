package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection connection = null;

    private ConnectDB() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost/game-library?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão realizada com sucesso!");
        }
        return connection;
    }

    public static boolean closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Conexão fechada com sucesso!");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Connection restartConnection() throws SQLException {
        closeConnection();
        return getConnection();
    }
}
