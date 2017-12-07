package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="ContactMaster")
@Table(name="CONTACTMASTER")
public class ContactMaster implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "contactMaster_seq")
	@SequenceGenerator(sequenceName = "contactMaster_seq", allocationSize = 1, name = "contactMaster_seq")
	@Column(name="CONTACT_ID")
	private long contactId;
	
	@Column(name = "FIRST_NAME", length = 50)
    private String firstName;
	
	@Column(name = "LAST_NAME", length = 50)
    private String lastName;
	
	@Column(name = "PHONE_NO", length = 50)
    private String phoneNo;
	
	@Column(name = "EMAIL", length = 50)
    private String email;
	
	@Column(name = "COUNTRY", length = 50)
    private String country;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	 @OneToOne
     @JoinColumn(name = "CLIENT_ID") 
	private ClientMaster clientMaster;
	
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public ClientMaster getClientMaster() {
		return clientMaster;
	}

	public void setClientMaster(ClientMaster clientMaster) {
		this.clientMaster = clientMaster;
	}

	
	 
	 
}
