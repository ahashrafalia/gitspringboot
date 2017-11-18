package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditLog.class)
public abstract class AuditLog_ {

	public static volatile SingularAttribute<AuditLog, Long> auditId;
	public static volatile SingularAttribute<AuditLog, Date> modifiedOn;
	public static volatile SingularAttribute<AuditLog, String> fieldName;
	public static volatile SingularAttribute<AuditLog, String> eventName;
	public static volatile SingularAttribute<AuditLog, String> modifiedBy;
	public static volatile SingularAttribute<AuditLog, String> currentValue;

}

