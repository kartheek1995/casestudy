package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDetaisDao")
public class UserDetailsDaoImpl extends AbstractDao<Integer, UserDetails> implements UserDetailsDao{

	@Override
	public void addUser(UserDetails user) {
		persist(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserDetails> listUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<UserDetails>) criteria.list();
	}

	@Override
	public UserDetails getUserById(int id) {
		return getByKey(id);
	}

	@Override
	public void deleteUserByUserName(String username) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("userName",username));
		delete((UserDetails)criteria.uniqueResult());
	}

	@Override
	public UserDetails getUserByUserName(String username) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("userName",username));
		return (UserDetails)criteria.uniqueResult();
	}

	

}
