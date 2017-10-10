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
 * The persistent class for the subject_purchase_record database table.
 * 
 */
@Entity
@Table(name="subject_purchase_record")
public class SubjectPurchaseRecord  {//标的购买表
	private static final long serialVersionUID = 1L;
	private int id;
	private Double amount;  //购买金额
	private String bonusInfo;  //红包金额信息（app端实际投资额度+红包额度）
	private Date createDate;   //创建时间
	private String dealIp;  //交易ip
	private byte delflag; //是否删除
	private Double interest;  //结算利息
	private byte ispayment;   //是否还款  //是否还款   （0.待还款   ，1.已还款）
	private int lastProfitDay;  //最后计息日
	private Member member;  //会员表
	private int payInterestTimes;  //购买次数
	private String serialNumber;  //流水号
	private Subject subject;  //主题表
	private Date updateDate;  //修改时间

    public SubjectPurchaseRecord() {
		super();
	}

	public SubjectPurchaseRecord(Double amount, String bonusInfo,
			Date createDate, String dealIp, byte delflag, Double interest,
			byte ispayment, int lastProfitDay, Member member,
			int payInterestTimes, String serialNumber, Subject subject,
			Date updateDate) {
		super();
		this.amount = amount;
		this.bonusInfo = bonusInfo;
		this.createDate = createDate;
		this.dealIp = dealIp;
		this.delflag = delflag;
		this.interest = interest;
		this.ispayment = ispayment;
		this.lastProfitDay = lastProfitDay;
		this.member = member;
		this.payInterestTimes = payInterestTimes;
		this.serialNumber = serialNumber;
		this.subject = subject;
		this.updateDate = updateDate;
	}

	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(precision=10, scale=4)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Column(name="bonus_info", length=200)
	public String getBonusInfo() {
		return this.bonusInfo;
	}

	public void setBonusInfo(String bonusInfo) {
		this.bonusInfo = bonusInfo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="deal_ip", length=25)
	public String getDealIp() {
		return this.dealIp;
	}

	public void setDealIp(String dealIp) {
		this.dealIp = dealIp;
	}


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	@Column(precision=10, scale=4)
	public Double getInterest() {
		return this.interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}


	public byte getIspayment() {
		return this.ispayment;
	}

	public void setIspayment(byte ispayment) {
		this.ispayment = ispayment;
	}


	@Column(name="last_profit_day", nullable=false)
	public int getLastProfitDay() {
		return this.lastProfitDay;
	}

	public void setLastProfitDay(int lastProfitDay) {
		this.lastProfitDay = lastProfitDay;
	}

/*
	@Column(name="member_id")
	public BigInteger getMemberId() {
		return this.memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}

*/
	
	
	@Column(name="pay_interest_times")
	public int getPayInterestTimes() {
		return this.payInterestTimes;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public void setPayInterestTimes(int payInterestTimes) {
		this.payInterestTimes = payInterestTimes;
	}


	@Column(name="serial_number", length=50)
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	public Date getUpdateDate() {
		return this.updateDate;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id")
	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
