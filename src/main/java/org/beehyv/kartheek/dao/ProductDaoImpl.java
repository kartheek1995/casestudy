package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{

	@Override
	public void addProduct(Product product) {
		persist(product);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> listProducts() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>)criteria.list();
	}

	@Override
	public Product getProductById(int id) {
		return getByKey(id);
	}

	@Override
	public Product getProductByName(String productname) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("product_name", productname));
		return (Product)criteria.uniqueResult();
	}

	@Override
	public void deleteProduct(String productname) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("product_name", productname));
		delete((Product)criteria.uniqueResult());
	}

}
