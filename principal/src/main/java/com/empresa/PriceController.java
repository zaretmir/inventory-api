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
@RequestMapping("/api/price-management")
@CrossOrigin
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/entries/products/{product-id}")
	public Price createPriceEntry(@RequestBody Price price, @PathVariable("product-id") Long id) {
		return priceService.createPriceEntry(price, id);
	}
	
	@GetMapping("/entries/products/{product-id}")
	public List<Price> getEntriesByProductId(@PathVariable("product-id") Long id) {
		return priceService.getEntriesByProductId(id);		
	}
	
	@GetMapping("/entries") 
	public List<Price> getAllEntries() {
		return priceService.getAllEntries();
	}
	
	@DeleteMapping("/entries/products/{product-id}")
	public void deleteByProductId(@PathVariable("product-id") Long id) {
		priceService.deleteByProductId(id);
	}
	
	@DeleteMapping("/entries/{entry-id}")
	public void deletePrice(@PathVariable("entry-id") Long id) {
		priceService.deleteById(id);
	}
	
	
	

}
