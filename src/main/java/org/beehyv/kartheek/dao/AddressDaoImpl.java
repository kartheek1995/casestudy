package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Address;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {

	@Override
	public void addAddress(Address address) {
		persist(address);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> listAddressesbyuserId(int userId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("user.userId", userId));
		return (List<Address>) criteria.list();
	}

	@Override
	public Address getAddressById(int id) {
		return getByKey(id);
	}

	@Override
	public void deleteAddress(int id) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("addressId",id));
		delete((Address)criteria.uniqueResult());
	}

}
