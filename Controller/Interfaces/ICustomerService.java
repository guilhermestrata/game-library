package Controller.Interfaces;

import Model.Entities.Customer;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer findByDocument(String documentNumber);
}
