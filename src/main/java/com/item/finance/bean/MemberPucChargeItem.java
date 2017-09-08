package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the member_puc_charge_item database table.
 * 
 */
@Entity
@Table(name="member_puc_charge_item")
public class MemberPucChargeItem  {
	private String id;
	private String chargeInstitutionCode;
	private String chargeInstitutionName;
	private String chargeType;
	private String comment;
	private String customerCode;
	private BigInteger homeId;
	private Member member;
	private SysBizInstitution sysBizInstitution;

	public MemberPucChargeItem() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="charge_institution_code", nullable=false, length=50)
	public String getChargeInstitutionCode() {
		return this.chargeInstitutionCode;
	}

	public void setChargeInstitutionCode(String chargeInstitutionCode) {
		this.chargeInstitutionCode = chargeInstitutionCode;
	}


	@Column(name="charge_institution_name", nullable=false, length=50)
	public String getChargeInstitutionName() {
		return this.chargeInstitutionName;
	}

	public void setChargeInstitutionName(String chargeInstitutionName) {
		this.chargeInstitutionName = chargeInstitutionName;
	}


	@Column(name="charge_type", nullable=false, length=20)
	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}


	@Column(nullable=false, length=50)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Column(name="customer_code", nullable=false, length=50)
	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}


	@Column(name="home_id", nullable=false)
	public BigInteger getHomeId() {
		return this.homeId;
	}

	public void setHomeId(BigInteger homeId) {
		this.homeId = homeId;
	}


	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="member_id", nullable=false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	//bi-directional many-to-one association to SysBizInstitution
	@ManyToOne
	@JoinColumn(name="charge_institution_id", nullable=false)
	public SysBizInstitution getSysBizInstitution() {
		return this.sysBizInstitution;
	}

	public void setSysBizInstitution(SysBizInstitution sysBizInstitution) {
		this.sysBizInstitution = sysBizInstitution;
	}

}