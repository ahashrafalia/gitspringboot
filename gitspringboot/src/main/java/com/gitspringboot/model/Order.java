package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="ORDERS")
public class Order implements Serializable{

	private static final long serialVersionUID = -3906909227671851395L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ORDER_SEQ")
	@SequenceGenerator(sequenceName="ORDER_SEQ",allocationSize=1,name="ORDER_SEQ")
	@Column(name = "ORDER_ID", nullable = false)
	private long orderId;

	//@Column(name = "CUST_ID")
    //private long custId;
	
	 @Column(name = "TOTAL_PRICE", precision = 2)
     private double totPrice;
     
     @Column(name = "OREDER_DESC")
     private String orderDesc;
     
     @Column(name = "ORDER_DATE")  
     private Date orderDt;
     
     @Column(name = "LAST_UPDATED_TIME")
     private Date updatedTime;

     @OneToOne(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Invoice.class)
     private Invoice invoice;
     
	
	@ManyToOne(optional=false)
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	
	
	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
}
