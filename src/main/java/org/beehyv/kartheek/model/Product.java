package org.beehyv.kartheek.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="PRODUCTS")
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private int product_id;
	
	@Column(name="PRODUCT_NAME")
	private String product_name;
	
	@Column(name="PRODUCT_COST")
	private int price;
	
	@Column(name="PRODUCT_IMAGE")
	private String imgsrc;
	
	@Column(name="PRODUCT_DESRCIPTION")
	private String description;
	
	
	@Column(name="PRODUCT_CATEGORY")
	private String category;
	
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="ATTRIBUTE",joinColumns= @JoinColumn(name="PRODUCT_ID"))
	private Collection<AttributeValue> attributeslist = new ArrayList<AttributeValue>();
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Collection<AttributeValue> getAttributeslist() {
		return attributeslist;
	}

	public void setAttributeslist(Collection<AttributeValue> attributeslist) {
		this.attributeslist = attributeslist;
	}
}
