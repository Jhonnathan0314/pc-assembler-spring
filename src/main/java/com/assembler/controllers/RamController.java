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

import com.assembler.models.Ram;
import com.assembler.repositories.RamRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("ram")
@CrossOrigin("*")
public class RamController {
	//Declaracion de variables
	@Autowired
	private RamRepository ramRepository;

	@GetMapping("")
	public List<Ram> findAll(){
		return ramRepository.findAll();
	}

	@GetMapping("{id}")
	public Ram findById(@PathVariable int id) {
		return ramRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Ram create(@RequestBody Ram ram) {
		if(ram != null) {
			return ramRepository.save(ram);
		}
		return null;
	}

	@PutMapping("{id}")
	public Ram update(@PathVariable int id, @RequestBody Ram newRam) {
		Ram actualRam = ramRepository.findById(id).orElse(null);
		if(actualRam != null && newRam != null) {
			actualRam.setCapacity(newRam.getCapacity());
			actualRam.setVelocity(newRam.getVelocity());
			actualRam.setTecnology(newRam.getTecnology());
			return ramRepository.save(actualRam);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Ram ram = ramRepository.findById(id).orElse(null);
		if(ram != null) {
			ramRepository.deleteById(id);
		}
	}
}
