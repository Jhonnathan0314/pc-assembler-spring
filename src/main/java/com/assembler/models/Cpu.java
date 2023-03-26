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
@Table(name = "cpu")
public class Cpu {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCpu;
	private String name;
	private int cores;
	private int threads;
	private float baseFrequency;
	private float maxFrequency;
	private String memoryCache;
	private String consumption;
	
	//Metodos constructores
	public Cpu(String name, int cores, int threads, float baseFrequency, float maxFrequency, String memoryCache,
			String consumption) {
		super();
		this.name = name;
		this.cores = cores;
		this.threads = threads;
		this.baseFrequency = baseFrequency;
		this.maxFrequency = maxFrequency;
		this.memoryCache = memoryCache;
		this.consumption = consumption;
	}
	
	public Cpu() {
		
	}

	//Get y set
	public int getIdCpu() {
		return idCpu;
	}

	public void setIdCpu(int idCpu) {
		this.idCpu = idCpu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public float getBaseFrequency() {
		return baseFrequency;
	}

	public void setBaseFrequency(float baseFrequency) {
		this.baseFrequency = baseFrequency;
	}

	public float getMaxFrequency() {
		return maxFrequency;
	}

	public void setMaxFrequency(float maxFrequency) {
		this.maxFrequency = maxFrequency;
	}

	public String getMemoryCache() {
		return memoryCache;
	}

	public void setMemoryCache(String memoryCache) {
		this.memoryCache = memoryCache;
	}

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}
}
