package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the subject_purchase_record database table.
 * 
 */
@Entity
@Table(name="subject_purchase_record")
@NamedQuery(name="SubjectPurchaseRecord.findAll", query="SELECT s FROM SubjectPurchaseRecord s")
public class SubjectPurchaseRecord  {
	private static final long serialVersionUID = 1L;
	private String id;
	private BigDecimal amount;
	private String bonusInfo;
	private Date createDate;
	private String dealIp;
	private byte delflag;
	private BigDecimal interest;
	private byte ispayment;
	private int lastProfitDay;
	private BigInteger memberId;
	private int payInterestTimes;
	private String serialNumber;
	private BigInteger subjectId;
	private Date updateDate;

	public SubjectPurchaseRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(precision=10, scale=4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="bonus_info", length=200)
	public String getBonusInfo() {
		return this.bonusInfo;
	}

	public void setBonusInfo(String bonusInfo) {
		this.bonusInfo = bonusInfo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="deal_ip", length=25)
	public String getDealIp() {
		return this.dealIp;
	}

	public void setDealIp(String dealIp) {
		this.dealIp = dealIp;
	}


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	@Column(precision=10, scale=4)
	public BigDecimal getInterest() {
		return this.interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}


	public byte getIspayment() {
		return this.ispayment;
	}

	public void setIspayment(byte ispayment) {
		this.ispayment = ispayment;
	}


	@Column(name="last_profit_day", nullable=false)
	public int getLastProfitDay() {
		return this.lastProfitDay;
	}

	public void setLastProfitDay(int lastProfitDay) {
		this.lastProfitDay = lastProfitDay;
	}


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	@Column(name="pay_interest_times")
	public int getPayInterestTimes() {
		return this.payInterestTimes;
	}

	public void setPayInterestTimes(int payInterestTimes) {
		this.payInterestTimes = payInterestTimes;
	}


	@Column(name="serial_number", length=50)
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	@Column(name="subject_id")
	public BigInteger getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(BigInteger subjectId) {
		this.subjectId = subjectId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}