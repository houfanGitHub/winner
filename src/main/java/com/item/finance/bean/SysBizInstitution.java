package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the sys_biz_institution database table.
 * 
 */
@Entity
@Table(name="sys_biz_institution")
public class SysBizInstitution  {
	private int id;
	private String bizSubType;
	private String bizType;
	private String city;
	private String institutionCode;
	private String institutionName;
	private String province;
	private Set<MemberPucChargeItem> memberPucChargeItems = new HashSet<>();

	public SysBizInstitution() {
	}


	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="biz_sub_type", nullable=false, length=10)
	public String getBizSubType() {
		return this.bizSubType;
	}

	public void setBizSubType(String bizSubType) {
		this.bizSubType = bizSubType;
	}


	@Column(name="biz_type", nullable=false, length=10)
	public String getBizType() {
		return this.bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}


	@Column(nullable=false, length=20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="institution_code", nullable=false, length=50)
	public String getInstitutionCode() {
		return this.institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}


	@Column(name="institution_name", nullable=false, length=50)
	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}


	@Column(nullable=false, length=20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	//bi-directional many-to-one association to MemberPucChargeItem
	@OneToMany(mappedBy="sysBizInstitution")
	public Set<MemberPucChargeItem> getMemberPucChargeItems() {
		return this.memberPucChargeItems;
	}

	public void setMemberPucChargeItems(Set<MemberPucChargeItem> memberPucChargeItems) {
		this.memberPucChargeItems = memberPucChargeItems;
	}

	public MemberPucChargeItem addMemberPucChargeItem(MemberPucChargeItem memberPucChargeItem) {
		getMemberPucChargeItems().add(memberPucChargeItem);
		memberPucChargeItem.setSysBizInstitution(this);

		return memberPucChargeItem;
	}

	public MemberPucChargeItem removeMemberPucChargeItem(MemberPucChargeItem memberPucChargeItem) {
		getMemberPucChargeItems().remove(memberPucChargeItem);
		memberPucChargeItem.setSysBizInstitution(null);

		return memberPucChargeItem;
	}

}