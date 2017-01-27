package org.beehyv.kartheek.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.beehyv.kartheek.model.Product;
import org.beehyv.kartheek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	@Autowired
	public ProductService productService;
	
	@RequestMapping(value = "/products/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> Products = productService.listProducts();
        if(Products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(Products, HttpStatus.OK);
    }
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Product> getProduct(@PathVariable("id") int id){
		Product product = productService.getProductById(id);
		if(product==null){
			System.out.println("Product not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/category/{category}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Product>> getElectronics(@PathVariable("category") String category){
		List<Product> temp = productService.listProducts();
		List<Product> product= new ArrayList<Product>();
		for(Product p:temp){
			if(p.getCategory().equalsIgnoreCase(category)){
				product.add(p);
			}
		}
		if(product.isEmpty()){
			System.out.println("Products not found");
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/home")
	public String homePage(ModelMap model){
		return "redirect:/static/html/home.htm";
	}
	
	@RequestMapping(value="/{category}/{filter}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<HashSet<Product>> filterElectronics(@PathVariable("category") String category,@PathVariable("filter") int filter){
		HashSet<Product> filteredproducts = productService.filteredproducts(category,filter);
		if(filteredproducts.isEmpty()){
			System.out.println("Products not found");
			return new ResponseEntity<HashSet<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HashSet<Product>>(filteredproducts,HttpStatus.OK);
	}
}
