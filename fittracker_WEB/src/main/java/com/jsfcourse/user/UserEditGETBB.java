package com.jsfcourse.user;

import java.io.IOException;
import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.jsf.dao.UserDAO;
import com.jsf.entities.User;

@Named
@ViewScoped
public class UserEditGETBB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String PAGE_USER_LIST = "userList?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	
	private User user = new User();
	private User loaded = null;
	
	@Inject
	FacesContext context;
	
	@EJB
	UserDAO userDAO;
	
	public User getUser() {
		return user;
	}
	
	public void onLoad() throws IOException {
		if(!context.isPostback()) {
			if(!context.isValidationFailed() && user.getIdUser() != null) {
				loaded = userDAO.find(user.getIdUser());
			}
			if(loaded != null) {
				user = loaded;
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu <333", null));
			}
		}
	}
	
	public String saveData() {
		if(loaded == null) {
			return PAGE_STAY_AT_THE_SAME;
		}
		
		try {
			if(user.getIdUser() == null) {
				userDAO.create(user);
			} else {
				userDAO.merge(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas zapisu", null));
			return PAGE_STAY_AT_THE_SAME;
		}
		return PAGE_USER_LIST;
	}
}