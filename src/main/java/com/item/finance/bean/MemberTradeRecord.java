package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the member_trade_record database table.
 * 
 */
@Entity
@Table(name="member_trade_record")
public class MemberTradeRecord  {
	private String id;
	private BigDecimal amount;
	private String counterpart;
	private Date createDate;
	private String extField1;
	private String extField2;
	private String extField3;
	private byte fundFlow;
	private String tradeName;
	private String tradeNo;
	private byte tradeStatus;
	private String tradeType;
	private Date updateDate;
	private Member member;

	public MemberTradeRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(nullable=false, length=100)
	public String getCounterpart() {
		return this.counterpart;
	}

	public void setCounterpart(String counterpart) {
		this.counterpart = counterpart;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="ext_field_1", nullable=false, length=50)
	public String getExtField1() {
		return this.extField1;
	}

	public void setExtField1(String extField1) {
		this.extField1 = extField1;
	}


	@Column(name="ext_field_2", nullable=false, length=50)
	public String getExtField2() {
		return this.extField2;
	}

	public void setExtField2(String extField2) {
		this.extField2 = extField2;
	}


	@Column(name="ext_field_3", nullable=false, length=50)
	public String getExtField3() {
		return this.extField3;
	}

	public void setExtField3(String extField3) {
		this.extField3 = extField3;
	}


	@Column(name="fund_flow", nullable=false)
	public byte getFundFlow() {
		return this.fundFlow;
	}

	public void setFundFlow(byte fundFlow) {
		this.fundFlow = fundFlow;
	}


	@Column(name="trade_name", nullable=false, length=100)
	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}


	@Column(name="trade_no", nullable=false, length=50)
	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	@Column(name="trade_status", nullable=false)
	public byte getTradeStatus() {
		return this.tradeStatus;
	}

	public void setTradeStatus(byte tradeStatus) {
		this.tradeStatus = tradeStatus;
	}


	@Column(name="trade_type", nullable=false, length=20)
	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
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
	@JoinColumn(name="member_id", nullable=false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}