package com.empresa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import com.empresa.hangar.service.HangarService;
import com.empresa.product.builder.ProductBuilder;
import com.empresa.product.dto.ProductDto;
import com.empresa.product.model.Product;
import com.empresa.product.service.ProductService;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	Product_HangarService product_hangarService;
	
	@Autowired
	HangarService hangarService;
	
	// List all products
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> listProducts() {
		
		List<Product> products = productService.getProducts();
		
		List<ProductDto> dtos = products.stream().map(
				p -> ProductBuilder.convertToDto(p)).collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductDto>>( dtos, HttpStatus.OK );
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
		
		Product product = productService.getProductById(id);
		
		return new ResponseEntity<ProductDto>(
				ProductBuilder.convertToDto(product), HttpStatus.OK);
	}
	
	
	// New product
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto dto) {
		
		Product product = ProductBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Product>(
				productService.createProduct(product), HttpStatus.OK);
	}
	
	// Edit existing product
	@PutMapping("product/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody ProductDto dto) {
		
		Product product = ProductBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Product>(
				productService.editProduct(id, product), HttpStatus.OK);
	}
		
	// Get product matching first letter
	@GetMapping("/products/{letter}")
	public ResponseEntity<List<ProductDto>> listProductsByFirstLetter(@PathVariable char letter) {
		
		List<Product> products = productService.listProductsByFirstLetter(letter);
		
		List<ProductDto> dtos = products.stream().map(
				p -> ProductBuilder.convertToDto(p)).collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductDto>>( dtos, HttpStatus.OK );
	}
	
	// Products to uppercase
	@GetMapping("/products/uppercase")
	public ResponseEntity<List<ProductDto>> listProductsUpperCase() {
		
		List<Product> products = productService.listProductsUpperCase();
		
		List<ProductDto> dtos = products.stream().map(
				p -> ProductBuilder.convertToDto(p)).collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductDto>>( dtos, HttpStatus.OK );
	}
	
	// Get product with longest name
	@GetMapping("/products/longest")
	public Optional<Product> listProductsLongestName() {
		return productService.listProductsLongestName();
	}
	
	// a ctrl p_h
	@PostMapping(value="/productOfHangar", produces="application/json; charset=UTF-8")
	public Product_Hangar mapProductToHangar(@RequestBody ProductOfHangar productOfHangar) {
		
		Product_Hangar relationship = new Product_Hangar();
		relationship.setHangar_pk(productOfHangar.getHangar_pk());
		relationship.setProduct_pk(productOfHangar.getProduct_pk());
		relationship.setQtyph(productOfHangar.getQtyph());
		
		return product_hangarService.save(relationship);
	}
}
