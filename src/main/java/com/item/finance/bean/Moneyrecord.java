package com.item.finance.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the moneyrecord database table.
 * 
 */
@Entity
@NamedQuery(name="Moneyrecord.findAll", query="SELECT m FROM Moneyrecord m")
public class Moneyrecord  {
	
	private BigDecimal amount;
	private Date createDate;
	private BigInteger delFlag;
	private BigInteger memberId;
	private String serialNumber;
	private BigInteger status;

	public Moneyrecord() {
	}


	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public BigInteger getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(BigInteger delFlag) {
		this.delFlag = delFlag;
	}


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	@Column(name="serial_number")
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public BigInteger getStatus() {
		return this.status;
	}

	public void setStatus(BigInteger status) {
		this.status = status;
	}

}