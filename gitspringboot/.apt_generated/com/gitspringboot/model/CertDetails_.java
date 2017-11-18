package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CertDetails.class)
public abstract class CertDetails_ {

	public static volatile SingularAttribute<CertDetails, String> contactEmail;
	public static volatile SingularAttribute<CertDetails, String> certName;
	public static volatile SingularAttribute<CertDetails, String> contactName;
	public static volatile SingularAttribute<CertDetails, Long> certId;
	public static volatile SingularAttribute<CertDetails, Date> expDate;
	public static volatile SingularAttribute<CertDetails, String> status;

}

