package Controller.Services;

import Controller.Interfaces.IGameService;
import Controller.Utils.CustomerUtil;
import Model.Entities.Customer;
import Model.Entities.Game;
import Model.Interfaces.IGameRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GameService implements IGameService {
    private final IGameRepository gameRepository;

    public GameService(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public boolean addGame(Game game) {
        if (game.getTitle() == null || game.getTitle().isEmpty()) return false;
        if (game.getGender() == null || game.getGender().isEmpty()) return false;
        if (game.getPlatform() == null || game.getPlatform().isEmpty()) return false;
        if (game.getLaunchDate() < 1900 || game.getLaunchDate() > LocalDate.now().getYear()) return false;

        gameRepository.insert(game);
        return true;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public boolean updateGame(Game game) {
        if (game.getTitle() == null || game.getTitle().isEmpty()) return false;
        if (game.getGender() == null || game.getGender().isEmpty()) return false;
        if (game.getPlatform() == null || game.getPlatform().isEmpty()) return false;
        if (game.getLaunchDate() < 1900 || game.getLaunchDate() > LocalDate.now().getYear()) return false;

        gameRepository.update(game);
        System.out.println("Game atualizado com sucesso");

        return true;
    }

    @Override
    public void deleteGame(int id) {
        gameRepository.delete(id);
    }

    @Override
    public List<Game> orderGamesByCategory(String category) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getGender().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
