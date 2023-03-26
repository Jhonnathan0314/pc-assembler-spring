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
@Table(name = "board")
public class Board {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBoard;
	private String chipset;
	private String brand;
	
	//Metodos constructores
	public Board(String chipset, String brand) {
		super();
		this.chipset = chipset;
		this.brand = brand;
	}
	
	public Board() {
		
	}

	//Get y set
	public int getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(int idBoard) {
		this.idBoard = idBoard;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
