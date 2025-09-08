package Model;

import java.util.HashMap;
import java.util.Map;

public class SqlQueries {

    private static final Map<String, String> queries = new HashMap<>();

    static {
        // GAME QUERIES
        queries.put("game.insert",
                "INSERT INTO Games (title, gender, platform, launchDate, status) VALUES (?, ?, ?, ?, ?)");
        queries.put("game.findAll",
                "SELECT * FROM Games");
        queries.put("game.update",
                "UPDATE Games SET title=?, gender=?, platform=?, launchDate=?, status=? WHERE id=?");
        queries.put("game.delete",
                "DELETE FROM Games WHERE id=?");

        // COSTUMER QUERIES
        queries.put("customer.insert",
                "INSERT INTO Customers (firstName, lastName, documentNumber, birthDate, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)");
        queries.put("customer.findAll",
                "SELECT * FROM Customers");
        queries.put("customer.update",
                "UPDATE Customers SET firstName=?, lastName=?, documentNumber=?, birthDate=?, email=?, phoneNumber=? WHERE id=?");
        queries.put("customer.delete",
                "DELETE FROM Customers WHERE id=?");

    }

    public static String get(String key) {
        return queries.get(key);
    }
}
