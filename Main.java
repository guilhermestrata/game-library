import Controller.CustomerController;
import Controller.GameController;
import Controller.Services.CustomerService;
import Controller.Services.GameService;
import Model.Repositories.CustomerRepository;
import Model.Repositories.GameRepository;
import View.CustomerView;
import View.GameView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {

            GameView gameView = new GameView();
            CustomerView customerView = new CustomerView();

            GameService gameService = new GameService(new GameRepository());
            CustomerService customerService = new CustomerService(new CustomerRepository());

            new GameController(gameView, gameService);
            new CustomerController(customerView, customerService);

            JFrame mainFrame = new JFrame("Game & Customer Management");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(800, 600);
            mainFrame.setLocationRelativeTo(null);

            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("Games", gameView);
            tabs.addTab("Customers", customerView);

            mainFrame.add(tabs);
            mainFrame.setVisible(true);
        });

    }
}

