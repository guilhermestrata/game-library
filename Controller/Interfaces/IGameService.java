package Controller.Interfaces;

import Model.Entities.Customer;
import Model.Entities.Game;

import java.util.List;

public interface IGameService {
    boolean addGame(Game game);
    List<Game> getAllGames();
    boolean updateGame(Game game);
    void deleteGame(int id);
    List<Game> orderGamesByCategory(String category);
}
