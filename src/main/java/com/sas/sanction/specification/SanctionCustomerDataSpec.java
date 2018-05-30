package com.sas.sanction.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.TransactionSearchRequestDto;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.entities.SanctionCustomer_;
import com.sas.sanction.utils.SanctionUtils;

public class SanctionCustomerDataSpec implements Specification<SanctionCustomer> {

	
	 private TransactionSearchRequestDto transactionSearch ;
	 private CustomerSearchRequestDto customerSearch;
	 
	private  boolean isCustomer ;
	private boolean isTransanction;
	 
	public <T> SanctionCustomerDataSpec(T request) {
		if(request instanceof TransactionSearchRequestDto) {
			transactionSearch = (TransactionSearchRequestDto) request;
			isTransanction=true;
		}else if(request instanceof CustomerSearchRequestDto) {
			isCustomer= true;
			customerSearch =(CustomerSearchRequestDto) request;
		}
	}
	
	@Override
	public Predicate toPredicate(Root<SanctionCustomer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(isCustomer)	{	
			 if(SanctionUtils.isStringNotNullorEmpty(customerSearch.getFullname())) {
			      predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(SanctionCustomer_.fullName)), "%"+customerSearch.getFullname().toLowerCase()+"%" ));
			 	}
			 if (SanctionUtils.isStringNotNullorEmpty(customerSearch.getCustomerNumber())) {
			      predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomer_.customerId)), customerSearch.getCustomerNumber().toLowerCase() ));
			    }
			 if (SanctionUtils.isStringNotNullorEmpty(customerSearch.getNationalId())) {
			      predicates.add(criteriaBuilder.or(criteriaBuilder.in(criteriaBuilder.lower(root.get(SanctionCustomer_.uniqueId1))).value(customerSearch.getNationalId().toLowerCase()), 
			    		  criteriaBuilder.in(criteriaBuilder.lower(root.get(SanctionCustomer_.uniqueId2))).value(customerSearch.getNationalId().toLowerCase())));
			    }
			
		if(customerSearch.getScreeningDateTime()!=null ){
			 	if(customerSearch.getScreeningDateTime().length==1){
			 		predicates.add(criteriaBuilder.equal(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(customerSearch.getScreeningDateTime()[0])));
			 	}
			 	
			 	if(customerSearch.getScreeningDateTime().length==2){
			 		 predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(customerSearch.getScreeningDateTime()[0])));
			 		 predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(customerSearch.getScreeningDateTime()[1])));
			 	}
		}
			 
			 
			 if (customerSearch.getDob()!=null) {
				 predicates.add(criteriaBuilder.equal(root.get(SanctionCustomer_.dateOfBirth), SanctionUtils.removeTime(customerSearch.getDob())));
			    }
			 if(SanctionUtils.isStringNotNullorEmpty(customerSearch.getCurrentSanctionStatus())){
				 predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomer_.status)), customerSearch.getCurrentSanctionStatus().toLowerCase() ));
			 }
		}
		else if(isTransanction) {
				if(SanctionUtils.isStringNotNullorEmpty(transactionSearch.getTransactionRefNumber())) {
					predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomer_.transactionNo)), transactionSearch.getTransactionRefNumber().toLowerCase() ));
				}
				if(SanctionUtils.isStringNotNullorEmpty(transactionSearch.getTransactionType())) {
					predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomer_.transactionType)), transactionSearch.getTransactionType().toLowerCase() ));
				}
				if(SanctionUtils.isStringNotNullorEmpty(transactionSearch.getCurrentSanctionStatus())) {
					predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get(SanctionCustomer_.status)), transactionSearch.getCurrentSanctionStatus().toLowerCase() ));
				}
				if(transactionSearch.getAmountGreater()!=null && transactionSearch.getAmountGreater()!=BigDecimal.ZERO){
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomer_.transactionAmount), transactionSearch.getAmountGreater().doubleValue()));
				}
				if(transactionSearch.getAmountLess()!=null&& transactionSearch.getAmountLess()!=BigDecimal.ZERO){
					predicates.add(criteriaBuilder.lessThan(root.get(SanctionCustomer_.transactionAmount), transactionSearch.getAmountLess().doubleValue()));
				}
				if(transactionSearch.getTransactionDateTime()!=null ){
				 	if(transactionSearch.getTransactionDateTime().length==1){
				 		predicates.add(criteriaBuilder.equal(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(transactionSearch.getTransactionDateTime()[0])));
				 	}
				 	
				 	if(transactionSearch.getTransactionDateTime().length==2){
				 		 predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(transactionSearch.getTransactionDateTime()[0])));
				 		 predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(SanctionCustomer_.createdDt), SanctionUtils.removeTime(transactionSearch.getTransactionDateTime()[1])));
				 	}
			}
				
				
			}
		 return andTogether(predicates, criteriaBuilder);
	}
	 
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	  }

}
