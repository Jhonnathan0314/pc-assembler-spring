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
@Table(name = "ram")
public class Ram {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRam;
	private String capacity;
	private String velocity;
	private String tecnology;
	
	//Metodos constructores
	public Ram(String capacity, String velocity, String tecnology) {
		super();
		this.capacity = capacity;
		this.velocity = velocity;
		this.tecnology = tecnology;
	}
	
	public Ram() {
		
	}

	//Get y set
	public int getIdRam() {
		return idRam;
	}

	public void setIdRam(int idRam) {
		this.idRam = idRam;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getVelocity() {
		return velocity;
	}

	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}

	public String getTecnology() {
		return tecnology;
	}

	public void setTecnology(String tecnology) {
		this.tecnology = tecnology;
	}
}
