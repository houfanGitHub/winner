package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the member_deposit_record database table.
 * 
 */
@Entity
@Table(name="member_deposit_record")
public class MemberDepositRecord  {
	private String id;
	private BigDecimal amount;
	private Date createDate;
	private byte delFlag;
	private String payChannelName;
	private String payChannelOrderNo;
	private String serialNumber;
	private byte status;
	private Date updateDate;
	private Member member;

	public MemberDepositRecord() {
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
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


	@Column(name="pay_channel_name", nullable=false, length=20)
	public String getPayChannelName() {
		return this.payChannelName;
	}

	public void setPayChannelName(String payChannelName) {
		this.payChannelName = payChannelName;
	}


	@Column(name="pay_channel_order_no", nullable=false, length=50)
	public String getPayChannelOrderNo() {
		return this.payChannelOrderNo;
	}

	public void setPayChannelOrderNo(String payChannelOrderNo) {
		this.payChannelOrderNo = payChannelOrderNo;
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
	@Column(name="update_date", nullable=false)
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