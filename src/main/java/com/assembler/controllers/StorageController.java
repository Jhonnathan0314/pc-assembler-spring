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

import com.assembler.models.Storage;
import com.assembler.repositories.StorageRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("storage")
@CrossOrigin("*")
public class StorageController {
	//Declaracion de variables
	@Autowired
	private StorageRepository storageRepository;

	@GetMapping("")
	public List<Storage> findAll(){
		return storageRepository.findAll();
	}

	@GetMapping("{id}")
	public Storage findById(@PathVariable int id) {
		return storageRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Storage create(@RequestBody Storage storage) {
		if(storage != null) {
			return storageRepository.save(storage);
		}
		return null;
	}

	@PutMapping("{id}")
	public Storage update(@PathVariable int id, @RequestBody Storage newStorage) {
		Storage actualStorage = storageRepository.findById(id).orElse(null);
		if(actualStorage != null && newStorage != null) {
			actualStorage.setType(newStorage.getType());
			actualStorage.setCapacity(newStorage.getCapacity());
			return storageRepository.save(actualStorage);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Storage storage = storageRepository.findById(id).orElse(null);
		if(storage != null) {
			storageRepository.deleteById(id);
		}
	}
}
