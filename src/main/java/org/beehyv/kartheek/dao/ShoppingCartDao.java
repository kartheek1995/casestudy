package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.ShoppingCart;

public interface ShoppingCartDao {
	public void addCart(ShoppingCart cart);
	public List<ShoppingCart> listCarts();
	public ShoppingCart getCartbyUserId(int userId);
	public void deleteCartByUserId(int userId);
}
