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
	private String addr;
	private BigDecimal amount;
	private String comment;
	private Date createDate;
	private Date endDate;
	private BigDecimal interest;
	private String name;
	private String phone;
	private int productId;
	private String riskReveal;
	private String signedPhotos;
	private Date startDate;
	private byte status;
	private Date updateDate;
	private Member member;
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


	@Column(length=50)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Column(precision=10, scale=4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(length=1000)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
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


	@Column(name="product_id")
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
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