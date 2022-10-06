package com.aldeamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "arrays")
@Entity
public class ArraysEntity {
	
	@Id
	@Column(name = "id" )
	private Integer id;
	
	@Column(name = "input_array")
	private String inputArray;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputArray() {
		return inputArray;
	}

	public void setInputArray(String inputArray) {
		this.inputArray = inputArray;
	}
	
	
	
	

}
