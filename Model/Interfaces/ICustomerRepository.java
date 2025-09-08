package Model.Interfaces;

import Model.Entities.Customer;

import java.util.List;

public interface ICustomerRepository {
    void insert(Customer customer);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(int id);
}
