package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="CUSTOMER")
public class Customer implements Serializable{

	private static final long serialVersionUID = -8270318659244110902L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUSTOMER_SEQ")
	@Column(name="CUST_ID")
	private long custId;
	
	@Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    
    @Column(name = "LAST_NAME", nullable = false,length = 50)
    private String lastName;
    
    @Column(name = "STREET")
    private String street;
    
    @OneToMany(mappedBy="customer",targetEntity=Order.class,fetch=FetchType.LAZY)
    private Collection orders;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Collection getOrders() {
		return orders;
	}

	public void setOrders(Collection orders) {
		this.orders = orders;
	}
    
    
    
	
}
