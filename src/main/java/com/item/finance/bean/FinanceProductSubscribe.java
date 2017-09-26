package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the finance_product_subscribe database table.
 * 
 */
@Entity
@Table(name="finance_product_subscribe")
public class FinanceProductSubscribe  {
	private int id;
	private String addr;//所在地区
	private Double amount;//私募购买金额
	private String comment;//电子签署文档信息(私募合同)
	private String createDate;//添加时间
	private String endDate;//结束时间
	private BigDecimal interest;//私募结算收益
	private String name;//姓名
	private String phone;//联系电话
	//private int productId;
	private FinanceProductFunds financeProductFunds;//私募/股权类
	private String riskReveal;//风险揭示书
	private String signedPhotos;//签署拍照
	private String startDate;//开始时间
	private int status;//'是否处理(0:签署拍照|1:已签约|2:审核中|3:签署失败)',
	private String updateDate;//修改时间
	private Member member;//用户基本表
	//体验金购买标的表
	private Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords = new HashSet<>();

	public FinanceProductSubscribe() {
	}



	@Id
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="product_id")
	public FinanceProductFunds getFinanceProductFunds() {
		return financeProductFunds;
	}
	public void setFinanceProductFunds(FinanceProductFunds financeProductFunds) {
		this.financeProductFunds = financeProductFunds;
	}
	
	
	
	@Column(length=50)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Column(precision=10, scale=4)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Column(length=1000)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Column(precision=10, scale=4)
	public BigDecimal getInterest() {
		return this.interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}


	@Column(length=32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(length=13)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


/*	@Column(name="product_id")
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
*/

	@Column(name="risk_reveal", length=200)
	public String getRiskReveal() {
		return this.riskReveal;
	}

	public void setRiskReveal(String riskReveal) {
		this.riskReveal = riskReveal;
	}


	@Column(name="signed_photos", length=200)
	public String getSignedPhotos() {
		return this.signedPhotos;
	}

	public void setSignedPhotos(String signedPhotos) {
		this.signedPhotos = signedPhotos;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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


	//bi-directional many-to-one association to FinanceProductSubscribeRecord
	@OneToMany(mappedBy="financeProductSubscribe")
	public Set<FinanceProductSubscribeRecord> getFinanceProductSubscribeRecords() {
		return this.financeProductSubscribeRecords;
	}

	public void setFinanceProductSubscribeRecords(Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords) {
		this.financeProductSubscribeRecords = financeProductSubscribeRecords;
	}

	public FinanceProductSubscribeRecord addFinanceProductSubscribeRecord(FinanceProductSubscribeRecord financeProductSubscribeRecord) {
		getFinanceProductSubscribeRecords().add(financeProductSubscribeRecord);
		financeProductSubscribeRecord.setFinanceProductSubscribe(this);

		return financeProductSubscribeRecord;
	}

	public FinanceProductSubscribeRecord removeFinanceProductSubscribeRecord(FinanceProductSubscribeRecord financeProductSubscribeRecord) {
		getFinanceProductSubscribeRecords().remove(financeProductSubscribeRecord);
		financeProductSubscribeRecord.setFinanceProductSubscribe(null);

		return financeProductSubscribeRecord;
	}

}