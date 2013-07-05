package com.otv.user.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.otv.model.User;
import com.otv.user.dao.UserDao;
 
@Service("userService")
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
 
    @Autowired private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void updateUser(User user) {
		User old = userDao.findById(user.getId());
		if(old==null)
			return ;
		//cannot update so return null
		old.setName(user.getName());
		old.setSurname(user.getSurname());
		userDao.saveOrUpdate(old);
	}

	@Override
	public void deleteUser(Integer id) {

		User user = userDao.findById(id);
		if(user==null)
			return;
		userDao.delete(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
 
}