package com.gitspringboot.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.ClientMaster;
import com.gitspringboot.model.ClientMaster_;

public class ClientMasterSpecification {

	public static Specification<ClientMaster> withDynamicQuery(final String clientName) {
		return new Specification<ClientMaster>() {

			@Override
			public Predicate toPredicate(Root<ClientMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				if (clientName != null) {
					predicates.add(
							builder.and(builder.equal(root.get(ClientMaster_.clientName), clientName)));
				}
				Predicate[] predicatesArray = new Predicate[predicates.size()];
				return builder.and(predicates.toArray(predicatesArray));
			}

		};
	}
}
