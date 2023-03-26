/**
 * 
 */
package com.assembler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assembler.models.Board;

/**
 * @author Jonatan
 *
 */
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
