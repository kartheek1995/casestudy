package org.beehyv.kartheek.service;

import java.util.HashSet;
import java.util.List;

import org.beehyv.kartheek.model.Product;

public interface ProductService {
	public Product getProductById(int id);
	public Product getProductByName(String productname);
	public List<Product> listProducts();
	public void saveProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(String productname);
	public HashSet<Product> filteredproducts(String category,int filtervalue);
}
