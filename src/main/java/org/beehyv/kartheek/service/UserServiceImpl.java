package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.dao.UserDetailsDao;
import org.beehyv.kartheek.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDetailsDao userdao;
	
	public UserDetailsDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDetailsDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public UserDetails getUserById(int id) {
		return 	userdao.getUserById(id);
	}

	@Override
	public UserDetails getUserByName(String username) {
		return userdao.getUserByUserName(username);
	}

	@Override
	public void saveUser(UserDetails user) {
		userdao.addUser(user);
	}

	@Override
	public void updateUser(UserDetails user) {
		UserDetails tempuser = userdao.getUserById(user.getUserId());
		if(tempuser!=null){
			tempuser.setCart(user.getCart());
			tempuser.setDateOfBirth(user.getDateOfBirth());
			tempuser.setFirstName(user.getFirstName());
			tempuser.setLandlineNo(user.getLandlineNo());
			tempuser.setLastName(user.getLastName());
			tempuser.setListOfAdressess(user.getListOfAdressess());
			tempuser.setMobileNo(user.getMobileNo());
			tempuser.setOrder(user.getOrder());
			tempuser.setPassword(user.getPassword());
			tempuser.setRole(user.getRole());
			tempuser.setState(user.getState());
			tempuser.setUserName(user.getUserName());
		}
	}

	@Override
	public void deleteUserbyName(String username) {
		userdao.deleteUserByUserName(username);
	}

	@Override
	public List<UserDetails> listUsers() {
		return userdao.listUsers();
	}

	@Override
	public int getCartIdByUserName(String username) {
		UserDetails user= userdao.getUserByUserName(username);
		return user.getCart().getCartId();
	}

}
