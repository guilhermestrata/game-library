package Controller;

import Controller.Services.GameService;
import Model.Entities.Game;
import View.GameView;

import javax.swing.*;

public class GameController {
    private final GameView view;
    private final GameService service;

    public GameController(GameView view, GameService service) {
        this.view = view;
        this.service = service;
        initController();
        loadGames();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addGame());
        view.getEditButton().addActionListener(e -> editGame());
        view.getDeleteButton().addActionListener(e -> deleteGame());
    }

    private void loadGames() {
        view.getTableModel().setRowCount(0);
        for (Game game : service.getAllGames()) {
            view.getTableModel().addRow(new Object[]{
                    game.getId(),
                    game.getTitle(),
                    game.getGender(),
                    game.getPlatform(),
                    game.getLaunchDate(),
                    game.getStatus(),
                    game.getRating()
            });
        }
    }

    private void addGame() {
        try {
            String title = JOptionPane.showInputDialog("Título do game:");
            String gender = JOptionPane.showInputDialog("Gênero:");
            String platform = JOptionPane.showInputDialog("Plataforma:");
            int launchYear = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento:"));
            int rating = Integer.parseInt(JOptionPane.showInputDialog("Nota (0 a 10):"));

            Game game = new Game();
            game.setTitle(title);
            game.setGender(gender);
            game.setPlatform(platform);
            game.setLaunchDate(launchYear);
            game.setRating(rating);
            game.setStatus("Active");

            if (service.addGame(game)) {
                JOptionPane.showMessageDialog(null, "Game adicionado com sucesso!");
                loadGames();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar game. Verifique os dados.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: " + ex.getMessage());
        }
    }

    private void editGame() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um game para editar.");
            return;
        }

        try {
            String title = JOptionPane.showInputDialog("Título:", view.getTableModel().getValueAt(selectedRow, 1));
            String gender = JOptionPane.showInputDialog("Gênero:", view.getTableModel().getValueAt(selectedRow, 2));
            String platform = JOptionPane.showInputDialog("Plataforma:", view.getTableModel().getValueAt(selectedRow, 3));
            int launchYear = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento:", view.getTableModel().getValueAt(selectedRow, 4)));
            int rating = Integer.parseInt(JOptionPane.showInputDialog("Nota (0 a 10):", view.getTableModel().getValueAt(selectedRow, 6)));

            Game game = service.getAllGames().get(selectedRow);
            game.setTitle(title);
            game.setGender(gender);
            game.setPlatform(platform);
            game.setLaunchDate(launchYear);
            game.setRating(rating);

            if (service.updateGame(game)) {
                JOptionPane.showMessageDialog(null, "Game atualizado com sucesso!");
                loadGames();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar game. Verifique os dados.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: " + ex.getMessage());
        }
    }

    private void deleteGame() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um game para deletar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar este game?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = service.getAllGames().get(selectedRow).getId();
            service.deleteGame(id);
            loadGames();
        }
    }
}
