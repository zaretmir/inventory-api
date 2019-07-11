package com.empresa.hangar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.hangar.model.Hangar;

public interface HangarRepository extends JpaRepository<Hangar, Long> {
	
	Optional<Hangar> findById(long id);
	boolean existsHangarByName(String name);

}
