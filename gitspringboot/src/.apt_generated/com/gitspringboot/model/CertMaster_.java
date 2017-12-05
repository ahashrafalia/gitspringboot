package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CertMaster.class)
public abstract class CertMaster_ {

	public static volatile SingularAttribute<CertMaster, Long> clientId;
	public static volatile SingularAttribute<CertMaster, Date> createdDate;
	public static volatile SingularAttribute<CertMaster, String> certStatus;
	public static volatile SingularAttribute<CertMaster, String> certName;
	public static volatile SingularAttribute<CertMaster, Date> renewedDate;
	public static volatile SingularAttribute<CertMaster, Long> certId;
	public static volatile SingularAttribute<CertMaster, Date> expDate;
	public static volatile SingularAttribute<CertMaster, ClientMaster> clientMaster;

}

