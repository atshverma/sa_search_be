package com.sas.sanction.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.entities.ListDataVersion;
import com.sas.sanction.entities.ListDataVersion_;
import com.sas.sanction.utils.SanctionUtils;

public class ListMgmtVersionDataSpec implements Specification<ListDataVersion>{

private ListMgmtSearchRequestDto listMgmtSearchDto ;
	
	public ListMgmtVersionDataSpec(ListMgmtSearchRequestDto listMgmtSearchDto) {
		this.listMgmtSearchDto=listMgmtSearchDto;
	}
	
	@Override
	public Predicate toPredicate(Root<ListDataVersion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getCustomerName())) {
			  predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(ListDataVersion_.fullName)), "%"+listMgmtSearchDto.getCustomerName().toLowerCase()+"%" ));
		}
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getListNameUniqueSno())) {
			  predicates.add(criteriaBuilder.equal(root.get(ListDataVersion_.listMaster), Integer.parseInt(listMgmtSearchDto.getListNameUniqueSno())));
		}		
		if(listMgmtSearchDto.getDob()!=null) {
			 predicates.add(criteriaBuilder.equal(root.get(ListDataVersion_.dob), SanctionUtils.removeTime(listMgmtSearchDto.getDob())));
		}
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getNationalId())) {
			   predicates.add(criteriaBuilder.or(criteriaBuilder.in(criteriaBuilder.lower(root.get(ListDataVersion_.idNum1))).value(listMgmtSearchDto.getNationalId().toLowerCase()), 
			    		  criteriaBuilder.in(criteriaBuilder.lower(root.get(ListDataVersion_.idNum2))).value(listMgmtSearchDto.getNationalId().toLowerCase())));
		}
		
		 return andTogether(predicates, criteriaBuilder);
	}

	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	  }
}
