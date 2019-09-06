
package com.empresa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product.projection.ProductSimplified;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("api/stock-management")
@CrossOrigin
public class Product_HangarController {

	@Autowired
	Product_HangarService product_HangarService;

	/**
	 * Add stock of a product to an hangar
	 * 
	 */
	@PostMapping(value = "/entries", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Product_Hangar> mapProductToHangar(@Valid @RequestBody ProductOfHangar entryReq) {

		Product_Hangar entry = new Product_Hangar();
		entry.setHangarPk(entryReq.getHangarpk());
		entry.setProductPk(entryReq.getProductpk());
		entry.setQty(entryReq.getQty());

		return new ResponseEntity<Product_Hangar>(product_HangarService.save(entry), HttpStatus.OK);
	}
	
	@PutMapping(value = "/entries")
	public ResponseEntity<Product_Hangar> updateQty(@Valid @RequestBody ProductOfHangar updateReq) {
		
		return new ResponseEntity<Product_Hangar>(product_HangarService.updateQty(updateReq), HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/entries/hangar/{hangar-id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getProductsInHangar(@PathVariable("hangar-id") Long id,
			@RequestParam(defaultValue = "false") Boolean details) {

		List<Product_Hangar> products = product_HangarService.getEntriesByHangar(id);

		if (details) {
			List<ProductSimplified> productsExcerpt = product_HangarService.getProductsExcerpt(products);
			return new ResponseEntity<List<ProductSimplified>>(productsExcerpt, HttpStatus.OK);
		}

		return new ResponseEntity<List<Product_Hangar>>(products, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/entries/product/{product-id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getProductGlobalStock(@PathVariable("product-id") Long id,
			@RequestParam(defaultValue = "false") Boolean details) {

		List<Product_Hangar> products = product_HangarService.getEntriesByProduct(id);
		if (details) {
			List<ProductSimplified> productsExcerpt = product_HangarService.getProductsExcerpt(products);
			return new ResponseEntity<List<ProductSimplified>>(productsExcerpt, HttpStatus.OK);
		}

		return new ResponseEntity<List<Product_Hangar>>(products, HttpStatus.OK);
	}
	
	
}
