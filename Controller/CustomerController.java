package Controller;

import Controller.Services.CustomerService;
import Model.Entities.Customer;
import View.CustomerView;

import javax.swing.*;
import java.time.LocalDate;

public class CustomerController {

    private final CustomerView view;
    private final CustomerService service;

    public CustomerController(CustomerView view, CustomerService service) {
        this.view = view;
        this.service = service;
        initController();
        loadCustomers();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addCustomer());
        view.getEditButton().addActionListener(e -> editCustomer());
        view.getDeleteButton().addActionListener(e -> deleteCustomer());
    }

    private void loadCustomers() {
        view.getTableModel().setRowCount(0);
        for (Customer customer : service.getAllCustomers()) {
            view.getTableModel().addRow(new Object[]{
                    customer.getId(),
                    customer.getFirstName(),
                    customer.getEmail(),
                    customer.getBirthDate()
            });
        }
    }

    private void addCustomer() {
        try {
            String firstName = JOptionPane.showInputDialog("Primeiro nome:");
            String document = JOptionPane.showInputDialog("CPF:");
            String email = JOptionPane.showInputDialog("Email:");
            String birthdateStr = JOptionPane.showInputDialog("Data de nascimento (yyyy-mm-dd):");
            LocalDate birthdate = LocalDate.parse(birthdateStr);

            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setDocumentNumber(document);
            customer.setEmail(email);
            customer.setBirthDate(birthdate);

            if (service.addCustomer(customer)) {
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                loadCustomers();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente. Verifique os dados.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: " + ex.getMessage());
        }
    }

    private void editCustomer() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar.");
            return;
        }

        try {
            String firstName = JOptionPane.showInputDialog("Primeiro nome:", view.getTableModel().getValueAt(selectedRow, 1));
            String document = JOptionPane.showInputDialog("CPF:", service.getAllCustomers().get(selectedRow).getDocumentNumber());
            String email = JOptionPane.showInputDialog("Email:", view.getTableModel().getValueAt(selectedRow, 2));
            String birthdateStr  = JOptionPane.showInputDialog("Data de nascimento:", view.getTableModel().getValueAt(selectedRow, 3));
            LocalDate birthdate = LocalDate.parse(birthdateStr);


            Customer customer = service.getAllCustomers().get(selectedRow);
            customer.setFirstName(firstName);
            customer.setDocumentNumber(document);
            customer.setEmail(email);
            customer.setBirthDate(birthdate);

            service.updateCustomer(customer);
            loadCustomers();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: " + ex.getMessage());
        }
    }

    private void deleteCustomer() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para deletar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = service.getAllCustomers().get(selectedRow).getId();
            service.deleteCustomer(id);
            loadCustomers();
        }
    }
}
