/**
 * 
 */
package com.assembler.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jonatan
 *
 */
@Entity
@Table(name = "storage")
public class Storage {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStorage;
	private String type;
	private String capacity;
	
	//Metodos constructores
	public Storage(String type, String capacity) {
		super();
		this.type = type;
		this.capacity = capacity;
	}
	
	public Storage() {
		
	}

	//Get y set
	public int getIdStorage() {
		return idStorage;
	}

	public void setIdStorage(int idStorage) {
		this.idStorage = idStorage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
}
