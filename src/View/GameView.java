package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GameView extends JPanel {
    private JTable table;
    private JButton addButton, editButton, deleteButton;
    private DefaultTableModel tableModel;

    public GameView() {
        setLayout(new BorderLayout());
        String[] columns = {"ID", "Title", "Gender", "Platform", "Launch Date", "Status", "Rating"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        addButton = new JButton("Add Game");
        editButton = new JButton("Edit Game");
        deleteButton = new JButton("Delete Game");
        buttons.add(addButton);
        buttons.add(editButton);
        buttons.add(deleteButton);

        add(buttons, BorderLayout.SOUTH);
    }

    public JTable getTable() { return table; }
    public JButton getAddButton() { return addButton; }
    public JButton getEditButton() { return editButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public DefaultTableModel getTableModel() { return tableModel; }
}
