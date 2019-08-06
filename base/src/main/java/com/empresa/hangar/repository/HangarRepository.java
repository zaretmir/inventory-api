package com.empresa.hangar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.hangar.model.Hangar;

public interface HangarRepository extends JpaRepository<Hangar, Long> {
	
	Optional<Hangar> findById(long id);
	boolean existsHangarByName(String name);
	List<Hangar> findByIsStateTrue();
	Page<Hangar> findByIsStateTrue(Pageable pageable); // Revisar import

}
