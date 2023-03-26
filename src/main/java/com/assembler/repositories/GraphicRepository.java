/**
 * 
 */
package com.assembler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assembler.models.Graphic;

/**
 * @author Jonatan
 *
 */
public interface GraphicRepository extends JpaRepository<Graphic, Integer> {

}
