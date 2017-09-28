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
 * The persistent class for the member_account database table.
 * 
 */
@Entity
@Table(name="member_account")
public class MemberAccount  {
	private String id;
	private Double bbinAmount;  //体验金
	private Double bonusAmount;   //红包金额
	private Date createDate;   //创建时间
	private byte delflag;  //是否删除
	private Double imusealeBalance;  //冻结金额
	private Double investAmount;  //投资金额
	private Double totalProfit;  //累计收益
	private Date updateDate;  //修改时间
	private Double useableBalance;  //可用余额
	private Member member;

	public MemberAccount() {
	}

	public MemberAccount(Double bbinAmount, Double bonusAmount,
			Date createDate, byte delflag, Double imusealeBalance,
			Double investAmount, Double totalProfit, Date updateDate,
			Double useableBalance, Member member) {
		super();
		this.bbinAmount = bbinAmount;
		this.bonusAmount = bonusAmount;
		this.createDate = createDate;
		this.delflag = delflag;
		this.imusealeBalance = imusealeBalance;
		this.investAmount = investAmount;
		this.totalProfit = totalProfit;
		this.updateDate = updateDate;
		this.useableBalance = useableBalance;
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


	@Column(name="bbin_amount", precision=10, scale=4)
	public Double getBbinAmount() {
		return this.bbinAmount;
	}

	public void setBbinAmount(Double bbinAmount) {
		this.bbinAmount = bbinAmount;
	}


	@Column(name="bonus_amount", precision=10, scale=4)
	public Double getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	@Column(name="imuseale_balance", precision=10, scale=4)
	public Double getImusealeBalance() {
		return this.imusealeBalance;
	}

	public void setImusealeBalance(Double imusealeBalance) {
		this.imusealeBalance = imusealeBalance;
	}


	@Column(name="invest_amount", precision=10, scale=4)
	public Double getInvestAmount() {
		return this.investAmount;
	}

	public void setInvestAmount(Double investAmount) {
		this.investAmount = investAmount;
	}


	@Column(name="total_profit", precision=10, scale=4)
	public Double getTotalProfit() {
		return this.totalProfit;
	}

	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="useable_balance", precision=10, scale=4)
	public Double getUseableBalance() {
		return this.useableBalance;
	}

	public void setUseableBalance(Double useableBalance) {
		this.useableBalance = useableBalance;
	}


	//bi-directional many-to-one association to Member
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id",unique=true)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}