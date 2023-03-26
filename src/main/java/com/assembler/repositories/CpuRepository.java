/**
 * 
 */
package com.assembler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assembler.models.Cpu;

/**
 * @author Jonatan
 *
 */
public interface CpuRepository extends JpaRepository<Cpu, Integer> {

}
