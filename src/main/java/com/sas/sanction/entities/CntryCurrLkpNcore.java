package com.sas.sanction.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cntry_curr_lkp_ncore database table.
 * 
 */
@Entity
@Table(name="cntry_curr_lkp_ncore", schema="rskncore")
@NamedQuery(name="CntryCurrLkpNcore.findAll", query="SELECT c FROM CntryCurrLkpNcore c")
public class CntryCurrLkpNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CURR_CD_SNO")
	private long currCdSno;

	@Column(name="CNTRY_CD")
	private String cntryCd;

	@Column(name="CNTRY_CD_3")
	private String cntryCd3;

	@Column(name="CNTRY_NAME")
	private String cntryName;

	@Column(name="CNTRY_NUM")
	private double cntryNum;

	@Column(name="CURR_CD")
	private String currCd;

	//bi-directional many-to-one association to FinTranFactNcore
	@OneToMany(mappedBy="cntryCurrLkpNcore")
	private List<FinTranFactNcore> finTranFactNcores;

	public CntryCurrLkpNcore() {
	}

	public long getCurrCdSno() {
		return this.currCdSno;
	}

	public void setCurrCdSno(long currCdSno) {
		this.currCdSno = currCdSno;
	}

	public String getCntryCd() {
		return this.cntryCd;
	}

	public void setCntryCd(String cntryCd) {
		this.cntryCd = cntryCd;
	}

	public String getCntryCd3() {
		return this.cntryCd3;
	}

	public void setCntryCd3(String cntryCd3) {
		this.cntryCd3 = cntryCd3;
	}

	public String getCntryName() {
		return this.cntryName;
	}

	public void setCntryName(String cntryName) {
		this.cntryName = cntryName;
	}

	public double getCntryNum() {
		return this.cntryNum;
	}

	public void setCntryNum(double cntryNum) {
		this.cntryNum = cntryNum;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public List<FinTranFactNcore> getFinTranFactNcores() {
		return this.finTranFactNcores;
	}

	public void setFinTranFactNcores(List<FinTranFactNcore> finTranFactNcores) {
		this.finTranFactNcores = finTranFactNcores;
	}

	public FinTranFactNcore addFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().add(finTranFactNcore);
		finTranFactNcore.setCntryCurrLkpNcore(this);

		return finTranFactNcore;
	}

	public FinTranFactNcore removeFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().remove(finTranFactNcore);
		finTranFactNcore.setCntryCurrLkpNcore(null);

		return finTranFactNcore;
	}

}