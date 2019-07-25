package com.empresa.hangar.builder;

import com.empresa.hangar.dto.HangarDto;
import com.empresa.hangar.model.Hangar;

public class HangarBuilder {
	
	
	static public Hangar convertToEntity(HangarDto dto) {
		Hangar hangar = new Hangar();
		// hangar.setId(dto.getId());
		hangar.setName(dto.getName());
		hangar.setAddress(dto.getAddress());
		
		return hangar;		
	}
	
	static public HangarDto convertToDto(Hangar hangar) {
		HangarDto dto = new HangarDto();
		dto.setId(hangar.getId());
		dto.setName(hangar.getName());
		dto.setAddress(hangar.getAddress());
		
		return dto;
	}

}
