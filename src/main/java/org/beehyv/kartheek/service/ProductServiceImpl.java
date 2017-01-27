package org.beehyv.kartheek.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.beehyv.kartheek.dao.ProductDao;
import org.beehyv.kartheek.model.AttributeValue;
import org.beehyv.kartheek.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductDao productdao;
	
	@Override
	public Product getProductById(int id) {
		return productdao.getProductById(id);
	}

	@Override
	public Product getProductByName(String productname) {
		return productdao.getProductByName(productname);
	}

	@Override
	public List<Product> listProducts() {
		return productdao.listProducts();
	}

	@Override
	public void saveProduct(Product product) {
		productdao.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product tempproduct = productdao.getProductById(product.getProduct_id());
		if(tempproduct!=null){
			tempproduct.setAttributeslist(product.getAttributeslist());
			tempproduct.setCategory(product.getCategory());
			tempproduct.setDescription(product.getDescription());
			tempproduct.setImgsrc(product.getImgsrc());
			tempproduct.setPrice(product.getPrice());
			tempproduct.setProduct_name(product.getProduct_name());
		}
	}

	@Override
	public void deleteProduct(String productname) {
		productdao.deleteProduct(productname);
	}

	@Override
	public HashSet<Product> filteredproducts(String category, int filtervalue) {
		List<Product> unfiltered = productdao.listProducts();
		HashSet<Product> filtered = new HashSet<Product>();
		HashSet<Product> filtered2 = new HashSet<Product>();
		int a=0,b=0,c=0,d=0,e=0,f=0,h=0,g=0;
		if((filtervalue&1)!=0){
			a=1;
		}
		if((filtervalue&2)!=0){
			b=1;
		}
		if((filtervalue&4)!=0){
			c=1;
		}
		if((filtervalue&8)!=0){
			d=1;
		}
		if((filtervalue&16)!=0){
			e=1;
		}
		if((filtervalue&32)!=0){
			f=1;
		}
		if((filtervalue&64)!=0){
			g=1;
		}
		if((filtervalue&128)!=0){
			h=1;
		}
		for(Product p:unfiltered){
			if(p.getCategory().equalsIgnoreCase(category)){
				Collection<AttributeValue> atlist = p.getAttributeslist();
				if(p.getPrice()<999&&a==1){
					filtered.add(p);
				}
				if(p.getPrice()<=1999&&p.getPrice()>=1000&&b==1){
					filtered.add(p);
				}
				if(p.getPrice()<=9999&&p.getPrice()>=2000&&c==1){
					filtered.add(p);
				}
				if(p.getPrice()>=10000&&d==1){
					filtered.add(p);
				}
				for(AttributeValue at: atlist){
					if((at.getValue().equalsIgnoreCase("Sanspareils Greenlands")||at.getValue().equalsIgnoreCase("LG"))&&e==1){
						filtered2.add(p);
					}
				}
				for(AttributeValue at: atlist){
					if((at.getValue().equalsIgnoreCase("Nivia Orbit")||at.getValue().equalsIgnoreCase("Samsung"))&&f==1){
						filtered2.add(p);
					}
				}
				for(AttributeValue at: atlist){
					if((at.getValue().equalsIgnoreCase("Vector X")||at.getValue().equalsIgnoreCase("Sony"))&&g==1){
						filtered2.add(p);
					}
				}
				for(AttributeValue at: atlist){
					if((at.getValue().equalsIgnoreCase("New Balance")||at.getValue().equalsIgnoreCase("Panasonic"))&&h==1){
						filtered2.add(p);
					}
				}
			}
		}
		if(filtered.isEmpty() && filtered2.isEmpty()&& d!=1 && c!=1 && b!=1 && a!=1){
			for(Product pr:unfiltered){
				if(pr.getCategory().equalsIgnoreCase(category)){
					filtered.add(pr);
				}
			}
			return filtered;
		}
		if(filtered2.isEmpty()){
			return filtered;
		}
		if(filtered.isEmpty()){
			return filtered2;
		}
		filtered.retainAll(filtered2);
		return filtered;
	}

}
