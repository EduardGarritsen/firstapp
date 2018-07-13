package nl.hu.v1wac.firstapp.domain;

import java.util.List;

import nl.hu.v1wac.firstapp.persistence.CustomerDao;
import nl.hu.v1wac.firstapp.persistence.CustomerPostgresDaoImpl;

public class CompanyService {
	private CustomerDao customerDAO = new CustomerPostgresDaoImpl();
	
	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}
	
	public void deleteCustomer(int id) {
		Customer c = customerDAO.findById(id);
		
		if (c != null) {
			customerDAO.delete(c);
		} else throw new IllegalArgumentException("Id does not exist!");
	}
}
