package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rolelog database table.
 * 
 */
@Entity
@NamedQuery(name="Rolelog.findAll", query="SELECT r FROM Rolelog r")
public class Rolelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRoleLog;

	private Timestamp assignmentDate;

	private Timestamp removalDate;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Rolelog() {
	}

	public int getIdRoleLog() {
		return this.idRoleLog;
	}

	public void setIdRoleLog(int idRoleLog) {
		this.idRoleLog = idRoleLog;
	}

	public Timestamp getAssignmentDate() {
		return this.assignmentDate;
	}

	public void setAssignmentDate(Timestamp assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public Timestamp getRemovalDate() {
		return this.removalDate;
	}

	public void setRemovalDate(Timestamp removalDate) {
		this.removalDate = removalDate;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}