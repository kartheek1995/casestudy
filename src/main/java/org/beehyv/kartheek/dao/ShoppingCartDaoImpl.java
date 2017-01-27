package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.ShoppingCart;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("shoppingCartDao")
public class ShoppingCartDaoImpl extends AbstractDao<Integer, ShoppingCart> implements ShoppingCartDao{

	@Override
	public void addCart(ShoppingCart cart) {
		persist(cart);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShoppingCart> listCarts() {
		Criteria criteria = createEntityCriteria();
		return (List<ShoppingCart>)criteria.list();
	}

	@Override
	public ShoppingCart getCartbyUserId(int userId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("user.userId", userId));
		return (ShoppingCart) criteria.uniqueResult();
	}

	@Override
	public void deleteCartByUserId(int userId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("user.userId", userId));
		delete((ShoppingCart) criteria.uniqueResult());
	}

}
