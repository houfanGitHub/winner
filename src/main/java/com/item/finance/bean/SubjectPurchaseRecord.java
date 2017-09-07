package com.item.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the subject_purchase_record database table.
 * 标的购买表
 */
@Entity
@Table(name="subject_purchase_record")
@NamedQuery(name="SubjectPurchaseRecord.findAll", query="SELECT s FROM SubjectPurchaseRecord s")
public class SubjectPurchaseRecord  {

	private String id;
	private BigDecimal amount;
	private String bonusInfo;
	private Date createDate;
	private String dealIp;
	private byte delflag;
	private BigDecimal interest;
	private byte ispayment;
	private int lastProfitDay;
	private int payInterestTimes;
	private String serialNumber;
	private Date updateDate;
	private Member member;
	private Subject subject;

	public SubjectPurchaseRecord() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="bonus_info")
	public String getBonusInfo() {
		return this.bonusInfo;
	}

	public void setBonusInfo(String bonusInfo) {
		this.bonusInfo = bonusInfo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="deal_ip")
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


	@Column(name="last_profit_day")
	public int getLastProfitDay() {
		return this.lastProfitDay;
	}

	public void setLastProfitDay(int lastProfitDay) {
		this.lastProfitDay = lastProfitDay;
	}


	@Column(name="pay_interest_times")
	public int getPayInterestTimes() {
		return this.payInterestTimes;
	}

	public void setPayInterestTimes(int payInterestTimes) {
		this.payInterestTimes = payInterestTimes;
	}


	@Column(name="serial_number")
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	//bi-directional many-to-one association to Subject
	@ManyToOne
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}