package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.dao.AddressDao;
import org.beehyv.kartheek.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	public AddressDao addressdao;
	
	@Override
	public void saveAddress(Address address) {
		addressdao.addAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		addressdao.deleteAddress(address.getAddressId());
		
	}

	@Override
	public List<Address> listAddressByUserId(int userid) {
		return addressdao.listAddressesbyuserId(userid);
	}

	@Override
	public Address getAddressById(int id) {
		return addressdao.getAddressById(id);
	}

	@Override
	public void updateAddress(Address address) {
		Address tempaddress = addressdao.getAddressById(address.getAddressId());
		if(tempaddress!=null){
			tempaddress.setAddresstype(address.getAddresstype());
			tempaddress.setCity(address.getCity());
			tempaddress.setHouseno(address.getHouseno());
			tempaddress.setPincode(address.getPincode());
			tempaddress.setState(address.getState());
			tempaddress.setStreet(address.getStreet());
			tempaddress.setUser(address.getUser());
		}
	}

}
