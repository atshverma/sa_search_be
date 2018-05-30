package com.sas.sanction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the list_version database table.
 * 
 */
@Entity
@Table(name="list_version")
@NamedQuery(name="ListVersion.findAll", query="SELECT l FROM ListVersion l")
public class ListVersion extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="list_ver_sno")
	private int listVerSno;


	@Column(name="list_name")
	private String listName;

	@Column(name="list_order")
	private int listOrder;

	@Column(name="list_sub_type")
	private String listSubType;

	@Column(name="list_type")
	private String listType;

	//bi-directional many-to-one association to ListMaster
	@ManyToOne
	@JoinColumn(name="list_master_sno")
	private ListMaster listMaster;

	public ListVersion() {
	}

	public int getListVerSno() {
		return this.listVerSno;
	}

	public void setListVerSno(int listVerSno) {
		this.listVerSno = listVerSno;
	}

	public String getListName() {
		return this.listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public int getListOrder() {
		return this.listOrder;
	}

	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

	public String getListSubType() {
		return this.listSubType;
	}

	public void setListSubType(String listSubType) {
		this.listSubType = listSubType;
	}

	public String getListType() {
		return this.listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public ListMaster getListMaster() {
		return this.listMaster;
	}

	public void setListMaster(ListMaster listMaster) {
		this.listMaster = listMaster;
	}

}