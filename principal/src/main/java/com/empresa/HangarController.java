package com.empresa;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.hangar.builder.HangarBuilder;
import com.empresa.hangar.dto.HangarDto;
import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.hangar.service.HangarService;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("/api/hangar")
@CrossOrigin
public class HangarController {
	
	@Autowired
	HangarRepository hangarRepository;
	
	@Autowired
	HangarService hangarService;
	
	@Autowired
	Product_HangarService product_HangarService;
	
	
	@GetMapping("/hangars-all")
	public ResponseEntity<List<HangarDto>> list() {
		
		List<Hangar> hangars = hangarService.getHangarsStateTrue();
		List<HangarDto> dtos = hangars.stream().map(
				hangar -> HangarBuilder.convertToDto(hangar)).collect(Collectors.toList());
		
		return new ResponseEntity<List<HangarDto>>( dtos, HttpStatus.OK);
	}
	
	// Pagination testing
	@GetMapping("/hangars/{page}/{items}")
	public ResponseEntity<Page<HangarDto>> listPag(@PathVariable("page") int page, @PathVariable("items") int items) {
		
		Pageable pageRequest = PageRequest.of(page, items);
		
		Page<Hangar> hangars = hangarService.getActiveHangarsPage(pageRequest);
		
		//Page<Hangar> hangars = hangarRepository.findByIsStateTrue(pageRequest);
		
		Page<HangarDto> dtos = new PageImpl<HangarDto>(
				hangars.getContent().stream()
					.map(hangar -> HangarBuilder.convertToDto(hangar)).collect(Collectors.toList()),
				pageRequest,
				hangars.getTotalElements());
		
		return new ResponseEntity<Page<HangarDto>>( dtos, HttpStatus.OK);
	}
	
	@GetMapping("/hangar/{id}")
	public ResponseEntity<HangarDto> listById(@PathVariable("id") long id) {
		Hangar hangar = hangarService.getHangarById(id);
		HangarDto dto = HangarBuilder.convertToDto(hangar);
		
		return new ResponseEntity<HangarDto>( dto, HttpStatus.OK);
	}
	
	@PostMapping("/hangar")
	public ResponseEntity<Hangar> createHangar(@Valid @RequestBody HangarDto dto) {
		Hangar hangar = HangarBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Hangar>(hangarService.createHangar(hangar), HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Hangar> updateHangar(@PathVariable("id") Long id, @RequestBody HangarDto dto) {
		// ?
		Hangar update = HangarBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Hangar>(hangarService.updateHangar(id, update), HttpStatus.OK);	
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Hangar> deleteHangar(@PathVariable("id") Long id) {
		return new ResponseEntity<Hangar>(hangarService.logicDeleteHangar(id), HttpStatus.OK);
	}

}
