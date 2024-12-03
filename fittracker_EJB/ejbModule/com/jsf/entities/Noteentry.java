package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the noteentry database table.
 * 
 */
@Entity
@NamedQuery(name="Noteentry.findAll", query="SELECT n FROM Noteentry n")
public class Noteentry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idNoteEntry;

	private int reps;

	private int sets;

	private float weight;

	//bi-directional many-to-one association to Exercise
	@ManyToOne
	@JoinColumn(name="idExercise")
	private Exercise exercise;

	//bi-directional many-to-one association to Trainingnote
	@ManyToOne
	@JoinColumn(name="idTrainingNote")
	private Trainingnote trainingnote;

	public Noteentry() {
	}

	public int getIdNoteEntry() {
		return this.idNoteEntry;
	}

	public void setIdNoteEntry(int idNoteEntry) {
		this.idNoteEntry = idNoteEntry;
	}

	public int getReps() {
		return this.reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getSets() {
		return this.sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Exercise getExercise() {
		return this.exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Trainingnote getTrainingnote() {
		return this.trainingnote;
	}

	public void setTrainingnote(Trainingnote trainingnote) {
		this.trainingnote = trainingnote;
	}

}