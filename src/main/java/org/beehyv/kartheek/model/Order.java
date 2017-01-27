package org.beehyv.kartheek.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="PRODUCT_ID")
	private Product orderproduct;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	public Product getOrderproduct() {
		return orderproduct;
	}

	public void setOrderproduct(Product orderproduct) {
		this.orderproduct = orderproduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ADDRESS_ID")
	private Address shippingaddress;
	
	@Column(name="ORDER_DATE")
	@Temporal(value=TemporalType.DATE)
	private Date date;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private UserDetails user ;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	

	public Address getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(Address shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
