package com.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.price.model.Price;
import com.empresa.price.service.PriceService;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/product/{productId}")
	public Price createPriceEntry(@RequestBody Price price, @PathVariable Long productId) {
		return priceService.createPriceEntry(price, productId);
	}
	
	@GetMapping("/product/{productId}")
	public List<Price> getEntriesByProductId(@PathVariable Long productId) {
		return priceService.getEntriesByProductId(productId);		
	}
	
	@GetMapping("/prices") 
	public List<Price> getAllEntries() {
		return priceService.getAllEntries();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePrice(@PathVariable("id") Long id) {
		priceService.deleteById(id);
	}
	
	@DeleteMapping("/delete/product/{id}")
	public void deleteByProductId(@PathVariable("id") Long id) {
		priceService.deleteByProductId(id);
	}
	

}
