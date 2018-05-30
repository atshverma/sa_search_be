package com.sas.sanction.dto;

public class MatchingCriteriaDto {

	private  int uniqueSno; 
	
	private String matchingField; 
	
	private String matchType;
	
	private String matchingStrength;

	private boolean updateFlag = false;
	
	private boolean deleteFlag = false;
	
	private boolean newFlag = false;
	

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public boolean isNewFlag() {
		return newFlag;
	}

	public void setNewFlag(boolean newFlag) {
		this.newFlag = newFlag;
	}

	public int getUniqueSno() {
		return uniqueSno;
	}

	public void setUniqueSno(int uniqueSno) {
		this.uniqueSno = uniqueSno;
	}

	

	public String getMatchingField() {
		return matchingField;
	}

	public void setMatchingField(String matchingField) {
		this.matchingField = matchingField;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getMatchingStrength() {
		return matchingStrength;
	}

	public void setMatchingStrength(String matchingStrength) {
		this.matchingStrength = matchingStrength;
	}
	
	
	
	
}
