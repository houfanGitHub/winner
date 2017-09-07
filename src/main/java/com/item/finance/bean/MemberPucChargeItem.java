package com.item.finance.bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the member_puc_charge_item database table.
 * 缴费项目表
 */
@Entity
@Table(name="member_puc_charge_item")
@NamedQuery(name="MemberPucChargeItem.findAll", query="SELECT m FROM MemberPucChargeItem m")
public class MemberPucChargeItem  {

	private String id;
	private String chargeInstitutionCode;
	private String chargeInstitutionName;
	private String chargeType;
	private String comment;
	private String customerCode;
	private BigInteger homeId;
	private BigInteger memberId;
	private SysBizInstitution sysBizInstitution;

	public MemberPucChargeItem() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="charge_institution_code")
	public String getChargeInstitutionCode() {
		return this.chargeInstitutionCode;
	}

	public void setChargeInstitutionCode(String chargeInstitutionCode) {
		this.chargeInstitutionCode = chargeInstitutionCode;
	}


	@Column(name="charge_institution_name")
	public String getChargeInstitutionName() {
		return this.chargeInstitutionName;
	}

	public void setChargeInstitutionName(String chargeInstitutionName) {
		this.chargeInstitutionName = chargeInstitutionName;
	}


	@Column(name="charge_type")
	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}


	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Column(name="customer_code")
	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}


	@Column(name="home_id")
	public BigInteger getHomeId() {
		return this.homeId;
	}

	public void setHomeId(BigInteger homeId) {
		this.homeId = homeId;
	}


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	//bi-directional many-to-one association to SysBizInstitution
	@ManyToOne
	@JoinColumn(name="charge_institution_id")
	public SysBizInstitution getSysBizInstitution() {
		return this.sysBizInstitution;
	}

	public void setSysBizInstitution(SysBizInstitution sysBizInstitution) {
		this.sysBizInstitution = sysBizInstitution;
	}

}