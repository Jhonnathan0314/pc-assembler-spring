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

import com.assembler.models.Graphic;
import com.assembler.repositories.GraphicRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("graphic")
@CrossOrigin("*")
public class GraphicController {
	//Declaracion de variables
	@Autowired
	private GraphicRepository graphicRepository;

	@GetMapping("")
	public List<Graphic> findAll(){
		return graphicRepository.findAll();
	}

	@GetMapping("{id}")
	public Graphic findById(@PathVariable int id) {
		return graphicRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Graphic create(@RequestBody Graphic graphic) {
		if(graphic != null) {
			return graphicRepository.save(graphic);
		}
		return null;
	}

	@PutMapping("{id}")
	public Graphic update(@PathVariable int id, @RequestBody Graphic newGraphic) {
		Graphic actualGraphic = graphicRepository.findById(id).orElse(null);
		if(actualGraphic != null && newGraphic != null) {
			actualGraphic.setModel(newGraphic.getModel());
			actualGraphic.setMemory(newGraphic.getMemory());
			actualGraphic.setTecnology(newGraphic.getTecnology());
			return graphicRepository.save(actualGraphic);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Graphic graphic = graphicRepository.findById(id).orElse(null);
		if(graphic != null) {
			graphicRepository.deleteById(id);
		}
	}
}
