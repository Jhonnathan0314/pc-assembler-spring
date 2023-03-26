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
@Table(name = "power")
public class Power {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPower;
	private String model;
	private String certify;
	private String potential;
	
	//Metodos contructores
	public Power(String model, String certify, String potential) {
		super();
		this.model = model;
		this.certify = certify;
		this.potential = potential;
	}
	
	public Power() {
		
	}

	//Get y set
	public int getIdPower() {
		return idPower;
	}

	public void setIdPower(int idPower) {
		this.idPower = idPower;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCertify() {
		return certify;
	}

	public void setCertify(String certify) {
		this.certify = certify;
	}

	public String getPotential() {
		return potential;
	}

	public void setPotential(String potential) {
		this.potential = potential;
	}
}
