package org.beehyv.kartheek.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="CART")
public class ShoppingCart {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CART_ID")
	private int cartId;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="cart")
	private Collection<CartProduct>  productslist= new ArrayList<CartProduct>();
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private UserDetails user ;
	
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Collection<CartProduct> getProductslist() {
		return productslist;
	}

	public void setProductslist(Collection<CartProduct> productslist) {
		this.productslist = productslist;
	}
}
