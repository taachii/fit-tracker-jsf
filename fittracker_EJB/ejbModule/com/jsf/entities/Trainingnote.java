package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the trainingnote database table.
 * 
 */
@Entity
@NamedQuery(name="Trainingnote.findAll", query="SELECT t FROM Trainingnote t")
public class Trainingnote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTrainingNote;

	private Timestamp creationDate;

	private String noteTitle;

	//bi-directional many-to-one association to Noteentry
	@OneToMany(mappedBy="trainingnote")
	private List<Noteentry> noteentries;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Trainingnote() {
	}

	public int getIdTrainingNote() {
		return this.idTrainingNote;
	}

	public void setIdTrainingNote(int idTrainingNote) {
		this.idTrainingNote = idTrainingNote;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getNoteTitle() {
		return this.noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public List<Noteentry> getNoteentries() {
		return this.noteentries;
	}

	public void setNoteentries(List<Noteentry> noteentries) {
		this.noteentries = noteentries;
	}

	public Noteentry addNoteentry(Noteentry noteentry) {
		getNoteentries().add(noteentry);
		noteentry.setTrainingnote(this);

		return noteentry;
	}

	public Noteentry removeNoteentry(Noteentry noteentry) {
		getNoteentries().remove(noteentry);
		noteentry.setTrainingnote(null);

		return noteentry;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}