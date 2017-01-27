package org.beehyv.kartheek.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CART_PRODUCTS")
public class CartProduct {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CART_PRODUCT_ID")
	private int cartproductId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CART_ID")
	private ShoppingCart cart;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCartproductId() {
		return cartproductId;
	}

	public void setCartproductId(int cartproductId) {
		this.cartproductId = cartproductId;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
}
