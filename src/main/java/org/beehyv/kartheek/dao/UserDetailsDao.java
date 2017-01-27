package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.UserDetails;

public interface UserDetailsDao {
	public void addUser(UserDetails user);
	public List<UserDetails> listUsers();
	public UserDetails getUserById(int id);
	public void deleteUserByUserName(String username);
	public UserDetails getUserByUserName(String username);
}
