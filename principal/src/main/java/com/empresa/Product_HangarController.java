
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product.projection.ProductSimplified;
import com.empresa.product.service.ProductService;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.repository.Product_HangarRepository;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("api/stock-management")
@CrossOrigin
public class Product_HangarController {
	
	@Autowired
	Product_HangarService product_HangarService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	Product_HangarRepository product_HangarRepository;
	
	/**
	 * Add stock of a product to an hangar
	 * 
	 */	
	@PostMapping(value="/entries", produces="application/json; charset=UTF-8")
	public ResponseEntity<Product_Hangar> mapProductToHangar(@RequestBody ProductOfHangar productOfHangar) {
		
		Product_Hangar relationship = new Product_Hangar();
		relationship.setHangarpk(productOfHangar.getHangarpk());
		relationship.setProductpk(productOfHangar.getProductpk());
		relationship.setQtyph(productOfHangar.getQtyph());
		
		return new ResponseEntity<Product_Hangar>(product_HangarService.save(relationship), HttpStatus.OK);
	}
	

	@GetMapping(value="/entries/hangar/{hangar-id}", produces="application/json; charset=UTF-8")
	public ResponseEntity<?> getProductsInHangar(
			@PathVariable("hangar-id") Long id,
			@RequestParam(defaultValue = "false") Boolean details) {
		
		List<Product_Hangar> products = product_HangarService.getProductsByHangar(id);
		
		if (details) {
			List<ProductSimplified> producsExcerpt = product_HangarService.getProductsExcerpt(products);
			return new ResponseEntity<List<ProductSimplified>>(producsExcerpt, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Product_Hangar>>(products, HttpStatus.OK);	
	}
	

}
