package com.gitspringboot.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.CertMaster_;

public class CertMasterSpecification {

	
    
	public static Specification<CertMaster> withDate() {
		return new Specification<CertMaster>() {

			@Override
			public Predicate toPredicate(Root<CertMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				Calendar cal = new GregorianCalendar(2017, 11, 30);
				
				predicates.add(
							builder.and(builder.lessThanOrEqualTo(root.get(CertMaster_.expDate), cal.getTime())));
				
				System.out.println("CertMasterSpecification predicates size"+predicates.size());
				
				
				Predicate[] predicatesArray = new Predicate[predicates.size()];
				return builder.and(predicates.toArray(predicatesArray));
			}

		};
	}

}
