package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.User;

@Remote
public interface UserBusinessRemote {
	public List<User> getUsers();
	int deleteUser(int id);
	public int createUser(User user);
	int updateUser(int id, User user);
	//User findUserByID(int id);
}
