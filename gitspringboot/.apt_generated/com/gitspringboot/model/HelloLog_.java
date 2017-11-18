package com.gitspringboot.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HelloLog.class)
public abstract class HelloLog_ {

	public static volatile SingularAttribute<HelloLog, Integer> uid;
	public static volatile SingularAttribute<HelloLog, Date> timestamps;
	public static volatile SingularAttribute<HelloLog, String> name;

}

