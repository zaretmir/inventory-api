package com.empresa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.hangar.service.HangarService;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class GeneralController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HangarService hangarService;
	
	
	@GetMapping("/hangars")
	public List<Hangar> listHangars() {
		return hangarService.getHangars();
	}

	// Repo casero
	
	@Autowired
	HangarRepository hangarRepository;
	
	
	@PostConstruct
	public void init() {
		hangarRepository.save(new Hangar("H02", "Sacramento"));
		hangarRepository.save(new Hangar("H03", "Medellin"));
	}

}
