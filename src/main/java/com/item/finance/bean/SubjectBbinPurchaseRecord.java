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
	private String id;
	private BigDecimal amount;
	private Date createDate;
	private String dealIp;
	private byte delflag;
	private BigDecimal interest;
	private byte ispayment;
	private int lastProfitDay;
	private int payInterestTimes;
	private String serialNumber;
	private Date updateDate;
	private Set<MemberProfitRecord> memberProfitRecords;
	private Member member;
	private Subject subject;

	public SubjectBbinPurchaseRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
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


	//bi-directional many-to-one association to MemberProfitRecord
	@OneToMany(mappedBy="subjectBbinPurchaseRecord")
	public Set<MemberProfitRecord> getMemberProfitRecords() {
		return this.memberProfitRecords;
	}

	public void setMemberProfitRecords(Set<MemberProfitRecord> memberProfitRecords) {
		this.memberProfitRecords = memberProfitRecords;
	}

	public MemberProfitRecord addMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
		getMemberProfitRecords().add(memberProfitRecord);
		memberProfitRecord.setSubjectBbinPurchaseRecord(this);

		return memberProfitRecord;
	}

	public MemberProfitRecord removeMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
		getMemberProfitRecords().remove(memberProfitRecord);
		memberProfitRecord.setSubjectBbinPurchaseRecord(null);

		return memberProfitRecord;
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