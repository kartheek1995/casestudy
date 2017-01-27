package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.model.UserDetails;

public interface UserService {
	public UserDetails getUserById(int id);
	public UserDetails getUserByName(String username);
	public void saveUser(UserDetails user);
	public void updateUser(UserDetails user);
	public void deleteUserbyName(String username);
	public List<UserDetails> listUsers();
	public int getCartIdByUserName(String username);
}
