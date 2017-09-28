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
public class FinanceProductSubscribeRecord  {  //金融产品订阅记录表
	private String id;
	private Date createDate;  //创建时间
	private String filed1;  //备用字段
	private String newPath; //新签署文档路径
	private String orgPath;  //原签署文档路径
	private String status;   //状态
	private String subscribeId; //私募预约记录 id	
	private String techUserSeal; //e签宝个人印章
	private Date updateDate;  //修改时间
	private FinanceProductSubscribe financeProductSubscribe;   //理财类基金产品预约记录
	private Member member;  //会员表

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


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="subscribe_id")
	public String getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(String subscribeId) {
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tech_user_id")
	public FinanceProductSubscribe getFinanceProductSubscribe() {
		return this.financeProductSubscribe;
	}

	public void setFinanceProductSubscribe(FinanceProductSubscribe financeProductSubscribe) {
		this.financeProductSubscribe = financeProductSubscribe;
	}


	//bi-directional many-to-one association to Member
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}