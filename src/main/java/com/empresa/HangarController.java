package com.empresa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.hangar.service.HangarService;

@RestController
@RequestMapping("/api/hangar")
@CrossOrigin
public class HangarController {
	
	@Autowired
	HangarRepository hangarRepository;
	
	@Autowired
	HangarService hangarService;
	
	@GetMapping("/hangars")
	public List<Hangar> list() {
		return hangarService.getHangars();
	}
	
	@GetMapping("/hangar/{id}")
	public Hangar listById(@PathVariable("id") long id) {
		return hangarService.getHangarById(id);
	}
	
	@PostMapping("/hangar")
	public Hangar createHangar(@Valid @RequestBody Hangar hangar) {
		return hangarService.createHangar(hangar);
	}
	
	/*
	 * Edit Hangar name (other properties cannot be edited)
	 */
	@PutMapping("/update/{id}")
	public Hangar updateHangar(@PathVariable("id") Long id, @RequestBody Hangar update) {
		return hangarService.updateHangar(id, update);		
	}

}
