package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the member_withdraw_record database table.
 * 
 */
@Entity
@Table(name="member_withdraw_record")
public class MemberWithdrawRecord  {
	private String id;  
	private BigDecimal amount; //提现金额
	private String bankCard;  //卡号
	private String bankName;  //银行名称
	private String cardaddress;  //开户所在地
	private String channelName;  //打款通道  （富友,贝付）
	private Date createDate;  //添加时间
	private byte delFlag;  //删除
	private String serialNumber;   //流水号
	private byte status;   //'提现状态(0:待审核;1:已打款;2打款中;3:打款失败)',
	private Date updateDate;  //修改时间
	private Member member;

	public MemberWithdrawRecord() {
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


	@Column(name="bank_card", length=50)
	public String getBankCard() {
		return this.bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}


	@Column(name="bank_name", length=20)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	@Column(length=200)
	public String getCardaddress() {
		return this.cardaddress;
	}

	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}


	@Column(name="channel_name", length=200)
	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public byte getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(byte delFlag) {
		this.delFlag = delFlag;
	}


	@Column(name="serial_number", length=50)
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	@Column(nullable=false)
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
	@JoinColumn(name="member_id", nullable=false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}