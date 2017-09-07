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
 * The persistent class for the finance_product_subscribe_record database table.
 * 金融产品订阅记录表
 */
@Entity
@Table(name="finance_product_subscribe_record")
@NamedQuery(name="FinanceProductSubscribeRecord.findAll", query="SELECT f FROM FinanceProductSubscribeRecord f")
public class FinanceProductSubscribeRecord  {

	private String id;
	private Date createDate;
	private String filed1;
	private BigInteger memberId;
	private String newPath;
	private String orgPath;
	private int status;
	private BigInteger subscribeId;
	private String techUserId;
	private String techUserSeal;
	private Date updateDate;

	public FinanceProductSubscribeRecord() {
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


	public String getFiled1() {
		return this.filed1;
	}

	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	@Column(name="new_path")
	public String getNewPath() {
		return this.newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}


	@Column(name="org_path")
	public String getOrgPath() {
		return this.orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Column(name="subscribe_id")
	public BigInteger getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(BigInteger subscribeId) {
		this.subscribeId = subscribeId;
	}


	@Column(name="tech_user_id")
	public String getTechUserId() {
		return this.techUserId;
	}

	public void setTechUserId(String techUserId) {
		this.techUserId = techUserId;
	}


	@Column(name="tech_user_seal")
	public String getTechUserSeal() {
		return this.techUserSeal;
	}

	public void setTechUserSeal(String techUserSeal) {
		this.techUserSeal = techUserSeal;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}