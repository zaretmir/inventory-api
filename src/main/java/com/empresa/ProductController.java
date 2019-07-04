package com.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.product.model.CreateProduct;
import com.empresa.product.model.EditProduct;
import com.empresa.product.model.Product;
import com.empresa.product.model.ProductRequest;
import com.empresa.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// List all products
	@GetMapping("/products")
	public List<Product> listProducts() {
		return productService.getProducts();
	}
	
	// Get product by id
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	// New product
	@PostMapping("/product")
	public Product createProduct(@Validated(value = CreateProduct.class) @RequestBody ProductRequest reqProduct) {
		return productService.createProduct(reqProduct);
	}
	
	// Edit existing product
	@PutMapping("product/{id}")
	public Product editProduct(@PathVariable Long id, @Validated(value = EditProduct.class) @RequestBody Product reqProduct) {
		return productService.editProduct(id, reqProduct);
	}
	
	// Get product by hangar
	@GetMapping("/byHangarId/{id}")
	public List<Product> productsByHangar(@PathVariable("id") Long id) {
		return productService.getByHangar(id);
	}
	
	// Get product matching first letter
	@GetMapping("/products/{letter}")
	public List<Product> listProductsByFirstLetter(@PathVariable char letter) {
		return productService.listProductsByFirstLetter(letter);
	}
	
	// Products to uppercase
	@GetMapping("/products/uppercase")
	public List<Product> listProductsUpperCase() {
		return productService.listProductsUpperCase();
	}
	
	// Get product with longest name
	@GetMapping("/products/longest")
	public Optional<Product> listProductsLongestName() {
		return productService.listProductsLongestName();
	}
}
