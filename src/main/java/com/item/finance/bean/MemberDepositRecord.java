package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the member_deposit_record database table.
 * 
 */
@Entity
@Table(name="member_deposit_record")
public class MemberDepositRecord  {//充值记录
	private String id;
	private Double amount;  //金额
	private Date createDate; //创建时间
	private byte delFlag;  //删除状态
	private String payChannelName; //充值渠道名称
	private String payChannelOrderNo;  //充值渠道订单号
	private String serialNumber;  //流水号
	private byte status;  //'状态(0:充值失败;1:充值成功)',
	private Date updateDate; //修改时间
	private Member member;

	public MemberDepositRecord() {
	}


	public MemberDepositRecord(Double amount, Date createDate,
			byte delFlag, String payChannelName, String payChannelOrderNo,
			String serialNumber, byte status, Date updateDate, Member member) {
		super();
		this.amount = amount;
		this.createDate = createDate;
		this.delFlag = delFlag;
		this.payChannelName = payChannelName;
		this.payChannelOrderNo = payChannelOrderNo;
		this.serialNumber = serialNumber;
		this.status = status;
		this.updateDate = updateDate;
		this.member = member;
	}


	@Id
	@GeneratedValue
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, precision=10, scale=2)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id", nullable=false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}