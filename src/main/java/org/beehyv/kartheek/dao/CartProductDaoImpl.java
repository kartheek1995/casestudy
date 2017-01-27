package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.CartProduct;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("cartProductDao")
public class CartProductDaoImpl extends AbstractDao<Integer, CartProduct> implements CartProductDao{

	@Override
	public void addCartProduct(CartProduct CartProduct) {
		persist(CartProduct);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CartProduct> listcartproducts(int cartid) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("cart.cartId", cartid));
		return (List<CartProduct>)criteria.list();
	}

	@Override
	public CartProduct getCartProductById(int id) {
		return getByKey(id);
	}

	@Override
	public CartProduct getCartProductByProductIdAndCartId(int productid, int cartid) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("cart.cartId", cartid))
				             .add(Restrictions.eq("product.product_id", productid));
		return (CartProduct) criteria.uniqueResult();
	}

	@Override
	public void deleteCartProduct(int id) {
		Criteria criteria= createEntityCriteria().add(Restrictions.eq("cartproductId", id));
		delete((CartProduct) criteria.uniqueResult());
	}
	
}
