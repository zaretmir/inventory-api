
package com.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("api/stock")
@CrossOrigin
public class Product_HangarController {
	
	@Autowired
	Product_HangarService product_HangarService;
	
	/**
	 * Add stock of a product to an hangar
	 * 
	 */	
	@PostMapping(value="/add-to-hangar", produces="application/json; charset=UTF-8")
	public ResponseEntity<Product_Hangar> mapProductToHangar(@RequestBody ProductOfHangar productOfHangar) {
		
		Product_Hangar relationship = new Product_Hangar();
		relationship.setHangarpk(productOfHangar.getHangarpk());
		relationship.setProductpk(productOfHangar.getProductpk());
		relationship.setQtyph(productOfHangar.getQtyph());
		
		return new ResponseEntity<Product_Hangar>(product_HangarService.save(relationship), HttpStatus.OK);
	}
	
	/**
	 * Returns a list of products that belong to a specific hangar
	 * 
	 */	
	@GetMapping(value="/all-products/{hangarId}", produces="application/json; charset=UTF-8")
	public ResponseEntity<List<Product_Hangar>> getProductsInHangar(@PathVariable Long hangarId) {
		List<Product_Hangar> products = product_HangarService.getProductsByHangar(hangarId);
		return new ResponseEntity<List<Product_Hangar>>(products, HttpStatus.OK);
		
	}
	

}
