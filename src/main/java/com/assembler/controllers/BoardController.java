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

import com.assembler.models.Board;
import com.assembler.repositories.BoardRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("board")
@CrossOrigin("*")
public class BoardController {
	//Declaracion de variables
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("")
	public List<Board> findAll(){
		return boardRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Board findById(@PathVariable int id) {
		return boardRepository.findById(id).orElse(null);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Board create(@RequestBody Board board) {
		if(board != null) {
			return boardRepository.save(board);
		}
		return null;
	}
	
	@PutMapping("{id}")
	public Board update(@PathVariable int id, @RequestBody Board newBoard) {
		Board actualBoard = boardRepository.findById(id).orElse(null);
		if(actualBoard != null && newBoard != null) {
			actualBoard.setChipset(newBoard.getChipset());
			actualBoard.setBrand(newBoard.getBrand());
			return boardRepository.save(actualBoard);
		}
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		Board board = boardRepository.findById(id).orElse(null);
		if(board != null) {
			boardRepository.deleteById(id);
		}
	}
}
