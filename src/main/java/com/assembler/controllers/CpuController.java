/**
 * 
 */
package com.assembler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assembler.models.Cpu;
import com.assembler.repositories.CpuRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("cpu")
@CrossOrigin("*")
public class CpuController {
	//Declaracion de variables
	@Autowired
	private CpuRepository cpuRepository;

	@GetMapping("")
	public List<Cpu> findAll(){
		return cpuRepository.findAll();
	}

	@GetMapping("{id}")
	public Cpu findById(@PathVariable int id) {
		return cpuRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Cpu create(@RequestBody Cpu cpu) {
		if(cpu != null) {
			return cpuRepository.save(cpu);
		}
		return null;
	}

	@PutMapping("{id}")
	public Cpu update(@PathVariable int id, @RequestBody Cpu newCpu) {
		Cpu actualCpu = cpuRepository.findById(id).orElse(null);
		if(actualCpu != null && newCpu != null) {
			actualCpu.setName(newCpu.getName());
			actualCpu.setCores(newCpu.getCores());
			actualCpu.setThreads(newCpu.getThreads());
			actualCpu.setBaseFrequency(newCpu.getBaseFrequency());
			actualCpu.setMaxFrequency(newCpu.getMaxFrequency());
			actualCpu.setMemoryCache(newCpu.getMemoryCache());
			actualCpu.setConsumption(newCpu.getConsumption());
			return cpuRepository.save(actualCpu);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Cpu cpu = cpuRepository.findById(id).orElse(null);
		if(cpu != null) {
			cpuRepository.deleteById(id);
		}
	}
}
