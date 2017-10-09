package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the member_trade_record database table.
 * 
 */
@Entity
@Table(name="member_trade_record")
public class MemberTradeRecord  {  //交易记录表
	private String id;
	private double amount;  //交易金额
	private String counterpart;//交易对方
	private Date createDate;   //交易时间
	private String extField1;//扩展1
	private String extField2;//扩张2
	private String extField3;//扩展3
	private byte fundFlow;  //资金流向(0:流出1:流入)',
	private String tradeName;  //交易名称
	private String tradeNo;  //交易号
	private byte tradeStatus; //交易状态( 0 交易失败    2 交易成功)
	private String tradeType; //交易分类
	private Date updateDate;//修改时间
	private Member member;   //会员表

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
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id", nullable=false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
