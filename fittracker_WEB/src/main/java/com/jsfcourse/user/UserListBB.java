package com.jsfcourse.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;

import com.jsf.dao.UserDAO;
import com.jsf.entities.User;


@Named
@RequestScoped
public class UserListBB {
	private static final String PAGE_USER_EDIT = "userEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private static final Logger logger = Logger.getLogger(UserListBB.class.getName());
	
	private String username;
	
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	UserDAO userDAO;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<User> getFullList() {
		return userDAO.getFullList();
	}
	
	public List<User> getList() {
		List<User> list = null;
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		
		if(username != null && username.length() > 0) {
			searchParams.put("username", username);
		}
		
		list = userDAO.getList(searchParams);
		return list;
	}
	
	public String newUser() {
		User user = new User();
		flash.put("user", user);
		return PAGE_USER_EDIT;
	}
	
	public String editUser(User user) {
		flash.put("user", user);
		return PAGE_USER_EDIT;
	}
	
	public String deleteUser(User user) {
		logger.info("Usuwam uzytkownika: #" + user.getIdUser() + " " + user.getUsername());
		userDAO.remove(user);
		return PAGE_STAY_AT_THE_SAME;
	}
}