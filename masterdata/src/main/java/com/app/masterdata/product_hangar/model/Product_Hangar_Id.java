package com.app.masterdata.product_hangar.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class Product_Hangar_Id implements Serializable {
	
	private static final long serialVersionUID = -6267293444346995566L;

	private Long hangarPk;
	
	private Long productPk;

	public Product_Hangar_Id(Long hangarpk, Long productpk) {
		this.hangarPk = hangarpk;
		this.productPk = productpk;
	}	
	
	public Product_Hangar_Id() {
	}

}
