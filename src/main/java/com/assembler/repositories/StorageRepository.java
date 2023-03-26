/**
 * 
 */
package com.assembler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assembler.models.Storage;

/**
 * @author Jonatan
 *
 */
public interface StorageRepository extends JpaRepository<Storage, Integer> {

}
