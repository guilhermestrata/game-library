package Controller.Services;

import Controller.Interfaces.ICustomerService;
import Controller.Utils.CustomerUtil;
import Model.Entities.Customer;
import Model.Interfaces.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
            System.out.println("Primeiro nome é obrigatório!");
            return false;
        }

        if (!CustomerUtil.isValidDocument(customer.getDocumentNumber())) {
            System.out.println("CPF inválido!");
            return false;
        }

        if (!CustomerUtil.isValidEmail(customer.getEmail())) {
            System.out.println("Email inválido!");
            return false;
        }

        customerRepository.insert(customer);
        return true;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (CustomerUtil.isValidDocument(customer.getDocumentNumber()) && CustomerUtil.isValidEmail(customer.getEmail())){
            customerRepository.update(customer);
            System.out.println("Cliente atualizado com sucesso");
        }
        else {
            System.out.println("Email ou Documento inválidos");
        }
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findByDocument(String documentNumber) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getDocumentNumber().equals(documentNumber))
                .findFirst()
                .orElse(null);
    }
}
