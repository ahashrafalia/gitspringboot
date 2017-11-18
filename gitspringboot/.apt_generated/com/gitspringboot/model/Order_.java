package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> updatedTime;
	public static volatile SingularAttribute<Order, Date> orderDt;
	public static volatile SingularAttribute<Order, Long> orderId;
	public static volatile SingularAttribute<Order, Double> totPrice;
	public static volatile SingularAttribute<Order, Invoice> invoice;
	public static volatile SingularAttribute<Order, String> orderDesc;
	public static volatile SingularAttribute<Order, Customer> customer;

}

