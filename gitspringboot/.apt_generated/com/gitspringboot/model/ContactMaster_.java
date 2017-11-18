package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContactMaster.class)
public abstract class ContactMaster_ {

	public static volatile SingularAttribute<ContactMaster, String> firstName;
	public static volatile SingularAttribute<ContactMaster, String> lastName;
	public static volatile SingularAttribute<ContactMaster, String> country;
	public static volatile SingularAttribute<ContactMaster, Date> createdDate;
	public static volatile SingularAttribute<ContactMaster, Long> contactId;
	public static volatile SingularAttribute<ContactMaster, String> phoneNo;
	public static volatile SingularAttribute<ContactMaster, String> email;
	public static volatile SingularAttribute<ContactMaster, ClientMaster> clientMaster;

}

