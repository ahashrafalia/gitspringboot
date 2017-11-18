package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Invoice.class)
public abstract class Invoice_ {

	public static volatile SingularAttribute<Invoice, Double> amountDue;
	public static volatile SingularAttribute<Invoice, Date> updatedTime;
	public static volatile SingularAttribute<Invoice, Date> orderCancelledDt;
	public static volatile SingularAttribute<Invoice, Date> orderRaisedDt;
	public static volatile SingularAttribute<Invoice, Date> orderSettledDt;
	public static volatile SingularAttribute<Invoice, Long> invoiceId;
	public static volatile SingularAttribute<Invoice, Order> order;

}

