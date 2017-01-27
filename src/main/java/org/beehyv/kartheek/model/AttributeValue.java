package org.beehyv.kartheek.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttributeValue {
	
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="ATTRIBUTE")
	private String attribute;
	
	@Column(name="VALUE")
	private String value;
}
