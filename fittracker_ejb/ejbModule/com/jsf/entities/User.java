package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	private Timestamp deactivationDate;

	private Timestamp editDate;

	private String email;

	private byte isActive;

	private String password;

	private Timestamp registrationDate;

	private String username;

	//bi-directional many-to-one association to Mentorship
	@OneToMany(mappedBy="user1")
	private List<Mentorship> mentorships1;

	//bi-directional many-to-one association to Mentorship
	@OneToMany(mappedBy="user2")
	private List<Mentorship> mentorships2;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="user1")
	private List<Request> requests1;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="user2")
	private List<Request> requests2;

	//bi-directional many-to-one association to Rolelog
	@OneToMany(mappedBy="user")
	private List<Rolelog> rolelogs;

	//bi-directional many-to-one association to Trainingnote
	@OneToMany(mappedBy="user")
	private List<Trainingnote> trainingnotes;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idEditor")
	private User user;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user")
	private List<User> users;

	public User() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Timestamp getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Timestamp deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public Timestamp getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Timestamp editDate) {
		this.editDate = editDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Mentorship> getMentorships1() {
		return this.mentorships1;
	}

	public void setMentorships1(List<Mentorship> mentorships1) {
		this.mentorships1 = mentorships1;
	}

	public Mentorship addMentorships1(Mentorship mentorships1) {
		getMentorships1().add(mentorships1);
		mentorships1.setUser1(this);

		return mentorships1;
	}

	public Mentorship removeMentorships1(Mentorship mentorships1) {
		getMentorships1().remove(mentorships1);
		mentorships1.setUser1(null);

		return mentorships1;
	}

	public List<Mentorship> getMentorships2() {
		return this.mentorships2;
	}

	public void setMentorships2(List<Mentorship> mentorships2) {
		this.mentorships2 = mentorships2;
	}

	public Mentorship addMentorships2(Mentorship mentorships2) {
		getMentorships2().add(mentorships2);
		mentorships2.setUser2(this);

		return mentorships2;
	}

	public Mentorship removeMentorships2(Mentorship mentorships2) {
		getMentorships2().remove(mentorships2);
		mentorships2.setUser2(null);

		return mentorships2;
	}

	public List<Request> getRequests1() {
		return this.requests1;
	}

	public void setRequests1(List<Request> requests1) {
		this.requests1 = requests1;
	}

	public Request addRequests1(Request requests1) {
		getRequests1().add(requests1);
		requests1.setUser1(this);

		return requests1;
	}

	public Request removeRequests1(Request requests1) {
		getRequests1().remove(requests1);
		requests1.setUser1(null);

		return requests1;
	}

	public List<Request> getRequests2() {
		return this.requests2;
	}

	public void setRequests2(List<Request> requests2) {
		this.requests2 = requests2;
	}

	public Request addRequests2(Request requests2) {
		getRequests2().add(requests2);
		requests2.setUser2(this);

		return requests2;
	}

	public Request removeRequests2(Request requests2) {
		getRequests2().remove(requests2);
		requests2.setUser2(null);

		return requests2;
	}

	public List<Rolelog> getRolelogs() {
		return this.rolelogs;
	}

	public void setRolelogs(List<Rolelog> rolelogs) {
		this.rolelogs = rolelogs;
	}

	public Rolelog addRolelog(Rolelog rolelog) {
		getRolelogs().add(rolelog);
		rolelog.setUser(this);

		return rolelog;
	}

	public Rolelog removeRolelog(Rolelog rolelog) {
		getRolelogs().remove(rolelog);
		rolelog.setUser(null);

		return rolelog;
	}

	public List<Trainingnote> getTrainingnotes() {
		return this.trainingnotes;
	}

	public void setTrainingnotes(List<Trainingnote> trainingnotes) {
		this.trainingnotes = trainingnotes;
	}

	public Trainingnote addTrainingnote(Trainingnote trainingnote) {
		getTrainingnotes().add(trainingnote);
		trainingnote.setUser(this);

		return trainingnote;
	}

	public Trainingnote removeTrainingnote(Trainingnote trainingnote) {
		getTrainingnotes().remove(trainingnote);
		trainingnote.setUser(null);

		return trainingnote;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUser(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUser(null);

		return user;
	}

}