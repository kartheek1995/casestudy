package org.beehyv.kartheek.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.beehyv.kartheek.enums.Role;
import org.beehyv.kartheek.enums.State;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	
	@Column(name="USER_NAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="BIRTH_DATE")
	private String dateOfBirth;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNo;

	@Column(name="LANDLINE_NUMBER")
	private String landlineNo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="user")
	private Collection<Address> listOfAdressess = new ArrayList<Address>();

	@OneToOne(cascade=CascadeType.PERSIST,mappedBy="user")
	private ShoppingCart cart;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="user")
	private List<Order> listOfOrders = new ArrayList<Order>();
	
	@Column(name="STATE")
	private String state= State.ACTIVE.getState();
	
	@Column(name="ROLE")
	private String role = Role.USER.getRole();
	
	public List<Order> getOrder() {
		return listOfOrders;
	}

	public void setOrder(List<Order> order) {
		this.listOfOrders = order;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public Collection<Address> getListOfAdressess() {
		return listOfAdressess;
	}

	public void setListOfAdressess(Collection<Address> listOfAdressess) {
		this.listOfAdressess = listOfAdressess;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
}
