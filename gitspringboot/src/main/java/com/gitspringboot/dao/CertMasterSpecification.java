package com.gitspringboot.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.CertMaster;

public class CertMasterSpecification implements Specification<CertMaster>{

	private CertMaster filter;

    public CertMasterSpecification(CertMaster filter) {
        super();
        this.filter = filter;
    }
    
	@Override
	public Predicate toPredicate(Root<CertMaster> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		
		 Predicate p = cb.disjunction();

	        if (filter.getCertName() != null) {
	            p.getExpressions()
	                    .add(cb.equal(root.get("certName"), filter.getCertName()));
	        }

	       /* if (filter.getSurname() != null && filter.getAge() != null) {
	            p.getExpressions().add(
	                    cb.and(cb.equal(root.get("surname"), filter.getSurname()),
	                            cb.equal(root.get("age"), filter.getAge())));
	        }*/

	        return p;
	}

}
