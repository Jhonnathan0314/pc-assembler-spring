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
@Table(name = "graphic")
public class Graphic {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGraphic;
	private String model;
	private String memory;
	private String tecnology;
	
	//Metodos constructores
	public Graphic(String model, String memory, String tecnology) {
		super();
		this.model = model;
		this.memory = memory;
		this.tecnology = tecnology;
	}
	
	public Graphic() {
		
	}

	//Get y set
	public int getIdGraphic() {
		return idGraphic;
	}

	public void setIdGraphic(int idGraphic) {
		this.idGraphic = idGraphic;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getTecnology() {
		return tecnology;
	}

	public void setTecnology(String tecnology) {
		this.tecnology = tecnology;
	}
}
