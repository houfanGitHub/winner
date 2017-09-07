package com.item.finance.bean;

import java.math.BigDecimal;
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
 * The persistent class for the member_tally database table.
 * 记账表
 */
@Entity
@Table(name="member_tally")
@NamedQuery(name="MemberTally.findAll", query="SELECT m FROM MemberTally m")
public class MemberTally  {

	private int id;
	private BigDecimal amount;
	private Date createDate;
	private BigInteger memberId;
	private Date payDate;
	private int typeId;
	private String typeName;

	public MemberTally() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="pay_date")
	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	@Column(name="type_id")
	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	@Column(name="type_name")
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}