package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.model.Address;

public interface AddressService {
	public void saveAddress(Address address);
	public void deleteAddress(Address address);
	public List<Address> listAddressByUserId(int id);
	public Address getAddressById(int id);
	public void updateAddress(Address address);
}
