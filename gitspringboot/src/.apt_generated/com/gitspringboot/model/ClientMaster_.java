package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClientMaster.class)
public abstract class ClientMaster_ {

	public static volatile SingularAttribute<ClientMaster, Long> clientId;
	public static volatile SingularAttribute<ClientMaster, Date> createdDate;
	public static volatile SingularAttribute<ClientMaster, String> clientName;
	public static volatile SetAttribute<ClientMaster, CertMaster> certMaster;
	public static volatile SingularAttribute<ClientMaster, ContactMaster> contactMaster;
	public static volatile SingularAttribute<ClientMaster, String> status;

}

