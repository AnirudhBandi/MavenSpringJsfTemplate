package com.otv.managed.bean;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otv.model.User;
import com.otv.user.service.UserService;
 

@Component(value="userMB")
@Scope(value="request")
public class UserManagedBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
 
    @Autowired UserService userService;
 
    private List<User> userList;
 
    private int id;
    private String name;
    private String surname;
 
    public String addUser() {
        try {
            User user = new User();
            user.setId(getId());
            user.setName(getName());
            user.setSurname(getSurname());
            getUserService().addUser(user);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
 
        return ERROR;
    }
 
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }
 
    public List<User> getUserList() {
        userList = new ArrayList<User>();
        userList=userService.getAllUsers();
        return userList;
    }
 
    public UserService getUserService() {
        return userService;
    }
 
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSurname() {
        return surname;
    }
 
    public void setSurname(String surname) {
        this.surname = surname;
    }
 
}