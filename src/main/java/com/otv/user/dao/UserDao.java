package com.otv.user.dao;
 
import java.util.List;
 
import com.otv.model.User;
 
public interface UserDao extends BaseDao<User,Integer>{
 
	public List<User> listAllUsers();
}