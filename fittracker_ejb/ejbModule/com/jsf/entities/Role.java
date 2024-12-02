package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRole;

	private Timestamp creationDate;

	private Timestamp deactivationDate;

	private byte isActive;

	private String roleName;

	//bi-directional many-to-one association to Rolelog
	@OneToMany(mappedBy="role")
	private List<Rolelog> rolelogs;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Timestamp deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Rolelog> getRolelogs() {
		return this.rolelogs;
	}

	public void setRolelogs(List<Rolelog> rolelogs) {
		this.rolelogs = rolelogs;
	}

	public Rolelog addRolelog(Rolelog rolelog) {
		getRolelogs().add(rolelog);
		rolelog.setRole(this);

		return rolelog;
	}

	public Rolelog removeRolelog(Rolelog rolelog) {
		getRolelogs().remove(rolelog);
		rolelog.setRole(null);

		return rolelog;
	}

}