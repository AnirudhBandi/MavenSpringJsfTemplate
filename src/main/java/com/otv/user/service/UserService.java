package com.otv.user.service;
 
import java.util.List;
 
import com.otv.model.User;
 
public interface UserService {
 
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer Id);
    public User getUserById(Integer Id);
    public List<User> getAllUsers();
}