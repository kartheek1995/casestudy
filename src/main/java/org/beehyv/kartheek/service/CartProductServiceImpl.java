package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.dao.CartProductDao;
import org.beehyv.kartheek.model.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cartproductService")
@Transactional
public class CartProductServiceImpl implements CartProductService{
	@Autowired
	public CartProductDao cpdao;

	@Override
	public void addCartProduct(CartProduct cartproduct) {
		cpdao.addCartProduct(cartproduct);
	}

	@Override
	public void updateCartProduct(CartProduct cartproduct) {
		CartProduct tempcp = cpdao.getCartProductById(cartproduct.getCartproductId());
		if(tempcp!=null){
			tempcp.setCart(cartproduct.getCart());
			tempcp.setProduct(cartproduct.getProduct());
			tempcp.setQuantity(cartproduct.getQuantity());
		}
	}

	@Override
	public void deleteCartProduct(int id) {
		cpdao.deleteCartProduct(id);
	}

	@Override
	public CartProduct getCartProduct(int id) {
		return cpdao.getCartProductById(id);
	}

	@Override
	public List<CartProduct> listCartProductsByCartId(int id) {
		return cpdao.listcartproducts(id);
	}

	@Override
	public CartProduct getCartProductByProductIdAndCartId(int productid, int cartid) {
		return cpdao.getCartProductByProductIdAndCartId(productid, cartid);
	}

}
