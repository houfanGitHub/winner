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
 * The persistent class for the member_trade_record database table.
 * 交易记录表
 */
@Entity
@Table(name="member_trade_record")
@NamedQuery(name="MemberTradeRecord.findAll", query="SELECT m FROM MemberTradeRecord m")
public class MemberTradeRecord  {

	private String id;
	private BigDecimal amount;
	private String counterpart;
	private Date createDate;
	private String extField1;
	private String extField2;
	private String extField3;
	private byte fundFlow;
	private BigInteger memberId;
	private String tradeName;
	private String tradeNo;
	private byte tradeStatus;
	private String tradeType;
	private Date updateDate;

	public MemberTradeRecord() {
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


	@Column(name="ext_field_1")
	public String getExtField1() {
		return this.extField1;
	}

	public void setExtField1(String extField1) {
		this.extField1 = extField1;
	}


	@Column(name="ext_field_2")
	public String getExtField2() {
		return this.extField2;
	}

	public void setExtField2(String extField2) {
		this.extField2 = extField2;
	}


	@Column(name="ext_field_3")
	public String getExtField3() {
		return this.extField3;
	}

	public void setExtField3(String extField3) {
		this.extField3 = extField3;
	}


	@Column(name="fund_flow")
	public byte getFundFlow() {
		return this.fundFlow;
	}

	public void setFundFlow(byte fundFlow) {
		this.fundFlow = fundFlow;
	}


	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}


	@Column(name="trade_name")
	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}


	@Column(name="trade_no")
	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	@Column(name="trade_status")
	public byte getTradeStatus() {
		return this.tradeStatus;
	}

	public void setTradeStatus(byte tradeStatus) {
		this.tradeStatus = tradeStatus;
	}


	@Column(name="trade_type")
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

}