package com.gitspringboot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ {

	public static volatile SingularAttribute<Article, Integer> articleId;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, String> category;

}

