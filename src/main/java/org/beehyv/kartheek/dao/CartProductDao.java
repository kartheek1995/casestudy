package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.CartProduct;

public interface CartProductDao {
	public void addCartProduct(CartProduct CartProduct);
	public List<CartProduct> listcartproducts(int cartid);
	public CartProduct getCartProductById(int id);
	public CartProduct getCartProductByProductIdAndCartId(int productid,int cartid);
	public void deleteCartProduct(int id);
}
