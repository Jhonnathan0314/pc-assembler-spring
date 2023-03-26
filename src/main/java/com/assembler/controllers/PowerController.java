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

import com.assembler.models.Power;
import com.assembler.repositories.PowerRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("power")
@CrossOrigin("*")
public class PowerController {
	//Declaracion de variables
	@Autowired
	private PowerRepository powerRepository;

	@GetMapping("")
	public List<Power> findAll(){
		return powerRepository.findAll();
	}

	@GetMapping("{id}")
	public Power findById(@PathVariable int id) {
		return powerRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Power create(@RequestBody Power power) {
		if(power != null) {
			return powerRepository.save(power);
		}
		return null;
	}

	@PutMapping("{id}")
	public Power update(@PathVariable int id, @RequestBody Power newPower) {
		Power actualPower = powerRepository.findById(id).orElse(null);
		if(actualPower != null && newPower != null) {
			actualPower.setModel(newPower.getModel());
			actualPower.setCertify(newPower.getCertify());
			actualPower.setPotential(newPower.getPotential());
			return powerRepository.save(actualPower);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Power power = powerRepository.findById(id).orElse(null);
		if(power != null) {
			powerRepository.deleteById(id);
		}
	}
}
