package Model.Interfaces;

import Model.Entities.Game;

import java.util.List;

public interface IGameRepository {
    void insert(Game game);
    List<Game> findAll();
    void update(Game game);
    void delete(int id);
}
