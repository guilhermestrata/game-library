package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerView extends JPanel {

    private JTable table;
    private JButton addButton, editButton, deleteButton;
    private DefaultTableModel tableModel;

    public CustomerView() {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Name", "Email", "Birthdate"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Customer");
        editButton = new JButton("Edit Customer");
        deleteButton = new JButton("Delete Customer");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() { return table; }
    public JButton getAddButton() { return addButton; }
    public JButton getEditButton() { return editButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public DefaultTableModel getTableModel() { return tableModel; }

    public void addCustomerRow(int id, String name, String email, String birthdate) {
        tableModel.addRow(new Object[]{id, name, email, birthdate});
    }

    public void removeCustomerRow(int rowIndex) {
        tableModel.removeRow(rowIndex);
    }

    public void updateCustomerRow(int rowIndex, int id, String name, String email, String birthdate) {
        tableModel.setValueAt(id, rowIndex, 0);
        tableModel.setValueAt(name, rowIndex, 1);
        tableModel.setValueAt(email, rowIndex, 2);
        tableModel.setValueAt(birthdate, rowIndex, 3);
    }
}
