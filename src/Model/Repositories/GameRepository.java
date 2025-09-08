package Model.Repositories;

import Model.ConnectDB;
import Model.Entities.Game;
import Model.Interfaces.IGameRepository;
import Model.SqlQueries;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GameRepository implements  IGameRepository {
    @Override
    public void insert(Game game) {
        String sql = SqlQueries.get("game.insert");

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getTitle());
            stmt.setString(2, game.getGender());
            stmt.setString(3, game.getPlatform());
            stmt.setInt(4, game.getLaunchDate());
            stmt.setString(5, game.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        String sql = SqlQueries.get("game.findAll");

        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setTitle(rs.getString("title"));
                game.setGender(rs.getString("gender"));
                game.setPlatform(rs.getString("platform"));
                game.setLaunchDate(rs.getInt("launchDate"));
                game.setStatus(rs.getString("status"));
                game.setRating(rs.getInt("rating"));

                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    @Override
    public void update(Game game) {
        String sql = SqlQueries.get("game.update");

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getTitle());
            stmt.setString(2, game.getGender());
            stmt.setString(3, game.getPlatform());
            stmt.setInt(4, game.getLaunchDate());
            stmt.setString(5, game.getStatus());
            stmt.setInt(6, game.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = SqlQueries.get("game.delete");

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
