package com.item.finance.bean;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sys_region database table.
 * 行政区表
 */
@Entity
@Table(name="sys_region")
@NamedQuery(name="SysRegion.findAll", query="SELECT s FROM SysRegion s")
public class SysRegion  {

	private String id;
	private Date createDate;
	private String diallingCode;
	private String gb2260;
	private Date lastModified;
	private String name;
	private String parentGb2260;
	private BigInteger parentId;
	private String parentIds;
	private byte regionLevel;

	public SysRegion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="dialling_code")
	public String getDiallingCode() {
		return this.diallingCode;
	}

	public void setDiallingCode(String diallingCode) {
		this.diallingCode = diallingCode;
	}


	public String getGb2260() {
		return this.gb2260;
	}

	public void setGb2260(String gb2260) {
		this.gb2260 = gb2260;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="parent_gb2260")
	public String getParentGb2260() {
		return this.parentGb2260;
	}

	public void setParentGb2260(String parentGb2260) {
		this.parentGb2260 = parentGb2260;
	}


	@Column(name="parent_id")
	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}


	@Column(name="parent_ids")
	public String getParentIds() {
		return this.parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}


	@Column(name="region_level")
	public byte getRegionLevel() {
		return this.regionLevel;
	}

	public void setRegionLevel(byte regionLevel) {
		this.regionLevel = regionLevel;
	}

}