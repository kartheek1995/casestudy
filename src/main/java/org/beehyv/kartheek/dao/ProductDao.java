package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public List<Product> listProducts();
	public Product getProductById(int id);
	public Product getProductByName(String productname);
	public void deleteProduct(String productname);
}
