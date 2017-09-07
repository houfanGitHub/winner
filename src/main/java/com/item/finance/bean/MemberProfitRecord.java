package com.item.finance.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 * The persistent class for the member_profit_record database table.
 * 成员利润记录表
 */
@Entity
@Table(name="member_profit_record")
@NamedQuery(name="MemberProfitRecord.findAll", query="SELECT m FROM MemberProfitRecord m")
public class MemberProfitRecord  {

	private String id;
	private BigDecimal amount;
	private String comment;
	private Date createDate;
	private byte delflag;
	private byte profitDay;
	private byte profitMonth;
	private short profitYear;
	private BigInteger purchaseId;
	private String serialNumber;
	private byte type;
	private Date updateDate;
	private Member member;

	public MemberProfitRecord() {
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


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	@Column(name="profit_day")
	public byte getProfitDay() {
		return this.profitDay;
	}

	public void setProfitDay(byte profitDay) {
		this.profitDay = profitDay;
	}


	@Column(name="profit_month")
	public byte getProfitMonth() {
		return this.profitMonth;
	}

	public void setProfitMonth(byte profitMonth) {
		this.profitMonth = profitMonth;
	}


	@Column(name="profit_year")
	public short getProfitYear() {
		return this.profitYear;
	}

	public void setProfitYear(short profitYear) {
		this.profitYear = profitYear;
	}


	@Column(name="purchase_id")
	public BigInteger getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(BigInteger purchaseId) {
		this.purchaseId = purchaseId;
	}


	@Column(name="serial_number")
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
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

}