package com.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.exception.EntityNotFoundException;
import com.empresa.product.builder.ProductBuilder;
import com.empresa.product.dto.ProductDto;
import com.empresa.product.model.Product;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api/product-management")
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

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {

		Product product = productService.getProductById(id);

		return new ResponseEntity<ProductDto>(ProductBuilder.convertToDto(product), HttpStatus.OK);
	}
	

	@GetMapping("/products/{page}/{items}")
	public ResponseEntity<Page<ProductDto>> productsPage(@PathVariable("page") int page,
			@PathVariable("items") int items) {

		Pageable pageRequest = PageRequest.of(page, items);
		Page<Product> products = productService.getActiveProductsPage(pageRequest);

		Page<ProductDto> response = new PageImpl<ProductDto>(
				products.stream().map(p -> ProductBuilder.convertToDto(p)).collect(Collectors.toList()),
				pageRequest,
				products.getTotalElements());

		return new ResponseEntity<Page<ProductDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDto dto) {

		Product product = ProductBuilder.convertToEntity(dto);

		return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.OK);
	}
	

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable Long id, @Valid @RequestBody ProductDto dto) {

		Product product = ProductBuilder.convertToEntity(dto);

		return new ResponseEntity<Product>(productService.editProduct(id, product), HttpStatus.OK);
	}
	

	@PutMapping("/products/delete/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable("id") Long id) {

		ProductDto response = ProductBuilder.convertToDto(productService.deleteProduct(id));

		return new ResponseEntity<ProductDto>(response, HttpStatus.OK);
	}
	

	@GetMapping("/products/order-by-letter/{letter}")
	public ResponseEntity<List<ProductDto>> listProductsByFirstLetter(@PathVariable("letter") char letter) {

		List<Product> products = productService.listProductsByFirstLetter(letter);

		List<ProductDto> response = products.stream()
				.map(p -> ProductBuilder.convertToDto(p))
				.collect(Collectors.toList());

		return new ResponseEntity<List<ProductDto>>(response, HttpStatus.OK);
	}

	// Products to uppercase
	@GetMapping("/products/uppercase")
	public ResponseEntity<List<ProductDto>> listProductsUpperCase() {

		List<Product> products = productService.listProductsUpperCase();

		List<ProductDto> response = products.stream()
				.map(p -> ProductBuilder.convertToDto(p))
				.collect(Collectors.toList());

		return new ResponseEntity<List<ProductDto>>(response, HttpStatus.OK);
	}

	// Get product with longest name
	@GetMapping("/products/longest")
	public Optional<Product> listProductsLongestName() {
		return productService.listProductsLongestName();
	}

}
