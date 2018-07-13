package nl.hu.v1wac.firstapp.persistence;

import nl.hu.v1wac.firstapp.domain.Address;

public interface AddressDao {
	public Address findById(int addressId);
	public boolean delete(Address address);
}
