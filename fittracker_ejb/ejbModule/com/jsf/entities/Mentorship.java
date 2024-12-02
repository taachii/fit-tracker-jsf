package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mentorship database table.
 * 
 */
@Entity
@NamedQuery(name="Mentorship.findAll", query="SELECT m FROM Mentorship m")
public class Mentorship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMentorship;

	private Timestamp endDate;

	private Timestamp startDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idTrainee")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idTrainer")
	private User user2;

	public Mentorship() {
	}

	public int getIdMentorship() {
		return this.idMentorship;
	}

	public void setIdMentorship(int idMentorship) {
		this.idMentorship = idMentorship;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}