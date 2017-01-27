package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.model.CartProduct;

public interface CartProductService {
	public void addCartProduct(CartProduct cartproduct);
	public void updateCartProduct(CartProduct cartproduct);
	public void deleteCartProduct(int id);
	public CartProduct getCartProduct(int id);
	public List<CartProduct> listCartProductsByCartId(int id);
	public CartProduct getCartProductByProductIdAndCartId(int productid,int cartid);
}
