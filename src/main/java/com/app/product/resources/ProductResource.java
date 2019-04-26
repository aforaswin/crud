package com.app.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.entities.Product;
import com.app.product.services.ProductService;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = "/v1/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable String id){
		return ResponseEntity.ok().body(productService.getProduct(id));
	}
	
	@RequestMapping(path = "/v1/products", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody final Product product){
		final Product saved = productService.add(product);
		return ResponseEntity.ok().body(saved);
	}

	@RequestMapping(path = "/v1/products", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody final Product product){
		final Product saved = productService.add(product);
		return ResponseEntity.ok().body(saved);
	}
	
	@RequestMapping(path = "/v1/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		final List<Product> saved = productService.getAllProducts();
		return ResponseEntity.ok().body(saved);
	}
	
	@RequestMapping(path = "/v1/products/{id}", method = RequestMethod.POST)
	public ResponseEntity<Product> deleteProduct(@PathVariable String id){
		final Product saved = productService.delete(id);
		return ResponseEntity.ok().body(saved);
	}

}
