package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static String status = "Não conectou...";

    public ConnectDB() {

    }

    public static java.sql.Connection getConnection() {
        Connection connection = null;

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "localhost";
            String mydatabase = "game-library";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, username, password);

            status = connection != null ? "STATUS---> Conexão realizada."
                                        : "STATUS---> Não foi possivel realizar conexão";

            return connection;
        }
        catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");

            return null;
        }
        catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;
        }
    }

    public static String statusConnection() {
        return status;
    }

    public static boolean closeConnection() {
        try {
            ConnectDB.getConnection().close();

            return true;
        }
        catch (SQLException e) {

            return false;
        }
    }

    public static java.sql.Connection restartConnection() {
        closeConnection();
        return ConnectDB.getConnection();
    }
}
