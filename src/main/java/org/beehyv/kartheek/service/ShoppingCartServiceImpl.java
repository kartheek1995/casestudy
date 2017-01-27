package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.dao.ShoppingCartDao;
import org.beehyv.kartheek.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shoppingcartService")
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Autowired
	public ShoppingCartDao cartdao;

	@Override
	public void addCart(ShoppingCart cart) {
		cartdao.addCart(cart);
	}

	@Override
	public void deleteCartByUserId(int id) {
		cartdao.deleteCartByUserId(id);
	}

	@Override
	public void updateCart(ShoppingCart cart) {
		ShoppingCart tempcart = cartdao.getCartbyUserId(cart.getUser().getUserId());
		if(tempcart!=null){
			tempcart.setProductslist(cart.getProductslist());
			tempcart.setUser(cart.getUser());
		}
	}

	@Override
	public ShoppingCart getCartByUserId(int id) {
		return cartdao.getCartbyUserId(id);
	}

	@Override
	public List<ShoppingCart> listAllCarts() {
		return cartdao.listCarts();
	}
}
