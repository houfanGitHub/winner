package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the finance_product_subscribe_record database table.
 * 
 */
@Entity
@Table(name="finance_product_subscribe_record")
public class FinanceProductSubscribeRecord  {
	private String id;
	private Date createDate;
	private String filed1;
	private String newPath;
	private String orgPath;
	private int status;
	private BigInteger subscribeId;
	private String techUserSeal;
	private Date updateDate;
	private FinanceProductSubscribe financeProductSubscribe;
	private Member member;

	public FinanceProductSubscribeRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
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


	@Column(length=100)
	public String getFiled1() {
		return this.filed1;
	}

	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}


	@Column(name="new_path", length=1000)
	public String getNewPath() {
		return this.newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}


	@Column(name="org_path", length=1000)
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


	@Column(name="tech_user_seal", length=1000)
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


	//bi-directional many-to-one association to FinanceProductSubscribe
	@ManyToOne
	@JoinColumn(name="tech_user_id")
	public FinanceProductSubscribe getFinanceProductSubscribe() {
		return this.financeProductSubscribe;
	}

	public void setFinanceProductSubscribe(FinanceProductSubscribe financeProductSubscribe) {
		this.financeProductSubscribe = financeProductSubscribe;
	}


	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}