package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the member_profit_record database table.
 * 
 */
@Entity
@Table(name="member_profit_record")
public class MemberProfitRecord  {
	private String id;
	private BigDecimal amount;
	private String comment;
	private Date createDate;
	private byte delflag;
	private byte profitDay;
	private byte profitMonth;
	private short profitYear;
	private String serialNumber;
	private byte type;
	private Date updateDate;
	private Member member;
	private SubjectBbinPurchaseRecord subjectBbinPurchaseRecord;

	public MemberProfitRecord() {
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


	@Column(nullable=false, length=100)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
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


	@Column(name="profit_day", nullable=false)
	public byte getProfitDay() {
		return this.profitDay;
	}

	public void setProfitDay(byte profitDay) {
		this.profitDay = profitDay;
	}


	@Column(name="profit_month", nullable=false)
	public byte getProfitMonth() {
		return this.profitMonth;
	}

	public void setProfitMonth(byte profitMonth) {
		this.profitMonth = profitMonth;
	}


	@Column(name="profit_year", nullable=false)
	public short getProfitYear() {
		return this.profitYear;
	}

	public void setProfitYear(short profitYear) {
		this.profitYear = profitYear;
	}


	@Column(name="serial_number", length=50)
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
	@Column(name="update_date", nullable=false)
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


	//bi-directional many-to-one association to SubjectBbinPurchaseRecord
	@ManyToOne
	@JoinColumn(name="purchase_id", nullable=false)
	public SubjectBbinPurchaseRecord getSubjectBbinPurchaseRecord() {
		return this.subjectBbinPurchaseRecord;
	}

	public void setSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
		this.subjectBbinPurchaseRecord = subjectBbinPurchaseRecord;
	}

}