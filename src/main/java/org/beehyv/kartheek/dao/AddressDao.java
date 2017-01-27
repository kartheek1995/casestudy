package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Address;


public interface AddressDao {
	public void addAddress(Address address);
	public List<Address> listAddressesbyuserId(int userId);
	public Address getAddressById(int id);
	public void deleteAddress(int id);
}
