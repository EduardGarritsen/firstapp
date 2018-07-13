package nl.hu.v1wac.firstapp.persistence;

import java.util.List;

import nl.hu.v1wac.firstapp.domain.Customer;

public interface CustomerDao {
	public List<Customer> findAll();
	public Customer findById(int customerId);
	public boolean delete(Customer customer);
}
