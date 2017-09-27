package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the subject_bbin_purchase_record database table.
 * 
 */
@Entity
@Table(name="subject_bbin_purchase_record")
public class SubjectBbinPurchaseRecord  {
	private int id;
	private BigDecimal amount;//购买金额
	private Date createDate;//创建时间
	private String dealIp;
	private String delflag;//是否删除
	private BigDecimal interest; //结算利息
	private byte ispayment;//是否还款
	private int lastProfitDay;   //最后计息日
	private int payInterestTimes;//支付时间
	private String serialNumber;//流水号
	private Date updateDate;  //修改时间
	private Member member;//(用户基本表)
	private Subject subject; //主题表
	
	public SubjectBbinPurchaseRecord() {
	}

	@Id
	@Column(unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@Column(precision=10, scale=4)
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


	@Column(name="deal_ip", length=25)
	public String getDealIp() {
		return this.dealIp;
	}

	public void setDealIp(String dealIp) {
		this.dealIp = dealIp;
	}


	/*public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}*/
	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Column(precision=10, scale=4)
	public BigDecimal getInterest() {
		return this.interest;
	}

	public void setInterest(BigDecimal interest) {
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


	@Column(name="pay_interest_times")
	public int getPayInterestTimes() {
		return this.payInterestTimes;
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


	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_id")
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}