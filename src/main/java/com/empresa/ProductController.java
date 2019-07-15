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

import com.empresa.hangar.service.HangarService;
import com.empresa.product.model.CreateProduct;
import com.empresa.product.model.EditProduct;
import com.empresa.product.model.Product;
import com.empresa.product.service.ProductService;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.service.Product_HangarService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	Product_HangarService product_hangarService;
	
	@Autowired
	HangarService hangarService;
	
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
	public Product createProduct(@Validated(value = CreateProduct.class) @RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	// Edit existing product
	@PutMapping("product/{id}")
	public Product editProduct(@PathVariable Long id, @Validated(value = EditProduct.class) @RequestBody Product reqProduct) {
		return productService.editProduct(id, reqProduct);
	}
	
	/*
	// Get product by hangar
	@GetMapping("/byHangarId/{id}")
	public List<Product> productsByHangar(@PathVariable("id") Long id) {
		return productService.getByHangar(id);
	}
	
	*/
	
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
