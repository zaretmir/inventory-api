package com.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product.builder.ProductBuilder;
import com.empresa.product.dto.ProductDto;
import com.empresa.product.model.Product;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getSearchResults(@RequestParam(required = false) String name) {
		List<Product> results = new ArrayList<Product>();
		
		if (name != null) {
			results = productService.getProductsMatchingSearch(name);
		} else {
			results = productService.getProducts();
		}
		 
		List<ProductDto> response = results.stream()
				.map(product -> ProductBuilder.convertToDto(product))
				.collect(Collectors.toList());
		return new ResponseEntity<List<ProductDto>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{page}/{items}")
	public ResponseEntity<Page<ProductDto>> productsPage(@PathVariable("page") int page, @PathVariable("items") int items) {
		
		Pageable pageRequest = PageRequest.of(page, items);
		
		Page<Product> products = productService.getActiveProductsPage(pageRequest);
		//productRepository.findByIsStateTrue(pageRequest);
		
		Page<ProductDto> dtos = new PageImpl<ProductDto>(
				products.stream()
					.map(p -> ProductBuilder.convertToDto(p)).collect(Collectors.toList()),
					pageRequest,
					products.getTotalElements());						
		
		return new ResponseEntity<Page<ProductDto>>( dtos, HttpStatus.OK );
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
		
		Product product = productService.getProductById(id);
		
		return new ResponseEntity<ProductDto>(
				ProductBuilder.convertToDto(product), HttpStatus.OK);
	}
	
	@GetMapping("product/simplified/{id}")
	public ResponseEntity<Object> getSimplifiedProduct(@PathVariable Long id) {
		return new ResponseEntity<Object>(productService.getSimplifiedProductById(id), HttpStatus.OK);
	}	
	
	// New product
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto dto) {
		
		Product product = ProductBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Product>(
				productService.createProduct(product), HttpStatus.OK);
	}
	
	// Edit existing product
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody ProductDto dto) {
		
		Product product = ProductBuilder.convertToEntity(dto);
		
		return new ResponseEntity<Product>(
				productService.editProduct(id, product), HttpStatus.OK);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable("id") Long id) {
		ProductDto dto = ProductBuilder.convertToDto(productService.deleteProduct(id));
		return new ResponseEntity<ProductDto>(
				dto, HttpStatus.OK);
		
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
	
	
}
