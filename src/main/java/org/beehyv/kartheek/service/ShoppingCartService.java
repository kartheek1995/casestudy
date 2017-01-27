package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.model.ShoppingCart;

public interface ShoppingCartService {
	public void addCart(ShoppingCart cart);
	public void deleteCartByUserId(int id);
	public void updateCart(ShoppingCart cart);
	public ShoppingCart getCartByUserId(int id);
	public List<ShoppingCart> listAllCarts();
}
