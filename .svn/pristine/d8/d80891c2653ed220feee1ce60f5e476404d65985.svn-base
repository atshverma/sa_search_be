package com.sas.sanction.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.entities.SanctionCustomerVersion;
import com.sas.sanction.entities.SanctionCustomerVersion_;
import com.sas.sanction.utils.SanctionUtils;

public class SanctionCustomerVersionDataSpec implements Specification<SanctionCustomerVersion>{

	private CustomerSearchRequestDto auditSearchRequestDto;
	
	public SanctionCustomerVersionDataSpec(CustomerSearchRequestDto auditSearchRequestDto) {
		this.auditSearchRequestDto = auditSearchRequestDto;
	}

	@Override
	public Predicate toPredicate(Root<SanctionCustomerVersion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		
		 if(SanctionUtils.isStringNotNullorEmpty(auditSearchRequestDto.getFullname())) {
		      predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(SanctionCustomerVersion_.fullName)), "%"+auditSearchRequestDto.getFullname().toLowerCase()+"%" ));
		 	}
		 if (SanctionUtils.isStringNotNullorEmpty(auditSearchRequestDto.getCustomerNumber())) {
		      predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomerVersion_.customerId)), auditSearchRequestDto.getCustomerNumber().toLowerCase() ));
		    }
		 if (SanctionUtils.isStringNotNullorEmpty(auditSearchRequestDto.getNationalId())) {
		      predicates.add(criteriaBuilder.or(criteriaBuilder.in(criteriaBuilder.lower(root.get(SanctionCustomerVersion_.uniqueId1))).value(auditSearchRequestDto.getNationalId().toLowerCase()), 
		    		  criteriaBuilder.in(criteriaBuilder.lower(root.get(SanctionCustomerVersion_.uniqueId2))).value(auditSearchRequestDto.getNationalId().toLowerCase())));
		    }
		 
			if(auditSearchRequestDto.getScreeningDateTime()!=null ){
			 	if(auditSearchRequestDto.getScreeningDateTime().length==1){
			 		predicates.add(criteriaBuilder.equal(root.get(SanctionCustomerVersion_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningDateTime()[0])));
			 	}
			 	
			 	if(auditSearchRequestDto.getScreeningDateTime().length==2){
			 		 predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomerVersion_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningDateTime()[0])));
			 		 predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(SanctionCustomerVersion_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningDateTime()[1])));
			 	}
		}
		 
		 /*if (auditSearchRequestDto.getScreeningDate()!=null ) {
		      predicates.add(criteriaBuilder.equal(root.get(SanctionCustomerVersion_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningDate())));
		    }*/
		 
		/* if (auditSearchRequestDto.getScreeningStartDate()!=null && auditSearchRequestDto.getScreeningEndDate()==null) {
		      predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningStartDate())));
		    }
		 if (auditSearchRequestDto.getScreeningEndDate()!=null && auditSearchRequestDto.getScreeningStartDate()==null) {
			 predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningEndDate())));
		    }
		 if (auditSearchRequestDto.getScreeningEndDate()!=null && auditSearchRequestDto.getScreeningStartDate()!=null) {
			 predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningEndDate())));
			 predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(auditSearchRequestDto.getScreeningStartDate())));
		    }*/
		 
		 if (auditSearchRequestDto.getDob()!=null) {
			 predicates.add(criteriaBuilder.equal(root.get(SanctionCustomerVersion_.dateOfBirth), SanctionUtils.removeTime(auditSearchRequestDto.getDob())));
		    }
		 if(SanctionUtils.isStringNotNullorEmpty(auditSearchRequestDto.getCurrentSanctionStatus())){
			 predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomerVersion_.status)), auditSearchRequestDto.getCurrentSanctionStatus().toLowerCase() ));
		 }
		
		 return andTogether(predicates, criteriaBuilder);
	}
			 
			
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	}


}
