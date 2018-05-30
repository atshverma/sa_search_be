package com.sas.sanction.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.entities.ListData;
import com.sas.sanction.entities.ListData_;
import com.sas.sanction.entities.ListMaster;
import com.sas.sanction.utils.SanctionUtils;



public class ListMgmtDataSpec implements Specification<ListData>{

	private ListMgmtSearchRequestDto listMgmtDto ;
	List<ListMaster> listTypes;
	
	public ListMgmtDataSpec(ListMgmtSearchRequestDto listMgmtDto, List<ListMaster> listTypes) {
		this.listMgmtDto=listMgmtDto;
		this.listTypes = listTypes;
	}
	
	@Override
	public Predicate toPredicate(Root<ListData> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtDto.getCustomerName())) {
			  predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(ListData_.fullName)), "%"+listMgmtDto.getCustomerName().toLowerCase()+"%" ));
		}
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtDto.getListNameUniqueSno())) {
			  predicates.add(criteriaBuilder.equal(root.get(ListData_.listMaster), Integer.parseInt(listMgmtDto.getListNameUniqueSno())));
		}		
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtDto.getListType())){
			List<Integer> allListMasterSNo = null;
			
			if(listTypes!=null && !listTypes.isEmpty()){
				allListMasterSNo = getAllListMasterSNo(listTypes);
			}
			predicates.add(root.get(ListData_.listMaster).in(allListMasterSNo));
		}
		
		
		if(listMgmtDto.getDob()!=null) {
			 predicates.add(criteriaBuilder.equal(root.get(ListData_.dob), SanctionUtils.removeTime(listMgmtDto.getDob())));
		}
		if(SanctionUtils.isStringNotNullorEmpty(listMgmtDto.getNationalId())) {
			   predicates.add(criteriaBuilder.or(criteriaBuilder.in(criteriaBuilder.lower(root.get(ListData_.idNum1))).value(listMgmtDto.getNationalId().toLowerCase()), 
			    		  criteriaBuilder.in(criteriaBuilder.lower(root.get(ListData_.idNum2))).value(listMgmtDto.getNationalId().toLowerCase())));
		}
		
		 return andTogether(predicates, criteriaBuilder);
	}

	private List<Integer> getAllListMasterSNo(List<ListMaster> listMasterList){
		List<Integer> listMasterSnoList = new ArrayList<>();
		
		for (ListMaster listMaster : listMasterList) {
			listMasterSnoList.add(listMaster.getListMasterSno());
		}
		return listMasterSnoList;
	}
	
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	  }
}
