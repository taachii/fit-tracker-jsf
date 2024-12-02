package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the exercise database table.
 * 
 */
@Entity
@NamedQuery(name="Exercise.findAll", query="SELECT e FROM Exercise e")
public class Exercise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idExercise;

	private String exerciseName;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="idType")
	private Type type;

	//bi-directional many-to-one association to Noteentry
	@OneToMany(mappedBy="exercise")
	private List<Noteentry> noteentries;

	public Exercise() {
	}

	public int getIdExercise() {
		return this.idExercise;
	}

	public void setIdExercise(int idExercise) {
		this.idExercise = idExercise;
	}

	public String getExerciseName() {
		return this.exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Noteentry> getNoteentries() {
		return this.noteentries;
	}

	public void setNoteentries(List<Noteentry> noteentries) {
		this.noteentries = noteentries;
	}

	public Noteentry addNoteentry(Noteentry noteentry) {
		getNoteentries().add(noteentry);
		noteentry.setExercise(this);

		return noteentry;
	}

	public Noteentry removeNoteentry(Noteentry noteentry) {
		getNoteentries().remove(noteentry);
		noteentry.setExercise(null);

		return noteentry;
	}

}