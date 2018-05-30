package com.sas.sanction.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the list_master database table.
 * 
 */
@Entity
@Table(name="list_master")
@NamedQuery(name="ListMaster.findAll", query="SELECT l FROM ListMaster l")
public class ListMaster extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="list_master_sno")
	private int listMasterSno;


	@Column(name="list_name")
	private String listName;

	@Column(name="list_order")
	private int listOrder;

	@Column(name="list_sub_type")
	private String listSubType;

	@Column(name="list_type")
	private String listType;


	//bi-directional many-to-one association to ListData
	@OneToMany(mappedBy="listMaster")
	private List<ListData> listData;

	//bi-directional many-to-one association to ListVersion
	@OneToMany(mappedBy="listMaster")
	private List<ListVersion> listVersions;

	//bi-directional many-to-one association to ListData
	@OneToMany(mappedBy="listMaster")
	private List<ListDataVersion> listDataVersion;
	
	
	public ListMaster() {
	}

	public int getListMasterSno() {
		return this.listMasterSno;
	}

	public void setListMasterSno(int listMasterSno) {
		this.listMasterSno = listMasterSno;
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


	public List<ListData> getListData() {
		return this.listData;
	}

	public void setListData(List<ListData> listData) {
		this.listData = listData;
	}

	public ListData addListData(ListData listData) {
		getListData().add(listData);
		listData.setListMaster(this);

		return listData;
	}

	public ListData removeListData(ListData listData) {
		getListData().remove(listData);
		listData.setListMaster(null);

		return listData;
	}

	public List<ListVersion> getListVersions() {
		return this.listVersions;
	}

	public void setListVersions(List<ListVersion> listVersions) {
		this.listVersions = listVersions;
	}

	public ListVersion addListVersion(ListVersion listVersion) {
		getListVersions().add(listVersion);
		listVersion.setListMaster(this);

		return listVersion;
	}

	public ListVersion removeListVersion(ListVersion listVersion) {
		getListVersions().remove(listVersion);
		listVersion.setListMaster(null);

		return listVersion;
	}

	public List<ListDataVersion> getListDataVersion() {
		return listDataVersion;
	}

	public void setListDataVersion(List<ListDataVersion> listDataVersion) {
		this.listDataVersion = listDataVersion;
	}
	
	

}