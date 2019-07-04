package com.empresa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.model.HangarRequest;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.hangar.service.HangarService;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api/hangar")
@CrossOrigin
public class HangarController {
	
	@Autowired
	HangarRepository hangarRepository;
	
	@Autowired
	HangarService hangarService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/hangars")
	public List<Hangar> list() {
		return hangarService.getHangars();
	}
	
	@GetMapping("/hangar/{id}")
	public Hangar listById(@PathVariable("id") long id) {
		return hangarService.getHangarById(id);
	}
	
	@GetMapping("/hangar")
	public Hangar createHangar(@Valid @RequestBody HangarRequest reqHangar) {
		return hangarService.createHangar(reqHangar);
	}
	
	@PostConstruct
	public void init() {
		hangarRepository.save(new Hangar("H01", "Cape City"));
		hangarRepository.save(new Hangar("H02", "Sacramento"));
		hangarRepository.save(new Hangar("H03", "Medellin"));
	}

}
