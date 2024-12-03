package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idType;

	private String typeName;

	//bi-directional many-to-one association to Exercise
	@OneToMany(mappedBy="type")
	private List<Exercise> exercises;

	public Type() {
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Exercise> getExercises() {
		return this.exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public Exercise addExercis(Exercise exercis) {
		getExercises().add(exercis);
		exercis.setType(this);

		return exercis;
	}

	public Exercise removeExercis(Exercise exercis) {
		getExercises().remove(exercis);
		exercis.setType(null);

		return exercis;
	}

}