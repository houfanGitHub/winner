package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the member_account database table.
 * 
 */
@Entity
@Table(name="member_account")
public class MemberAccount  {
	private String id;
	private BigDecimal bbinAmount;  //体验金
	private BigDecimal bonusAmount;   //红包金额
	private Date createDate;   //创建时间
	private byte delflag;  //是否删除
	private BigDecimal imusealeBalance;  //冻结金额
	private BigDecimal investAmount;  //投资金额
	private BigDecimal totalProfit;  //累计收益
	private Date updateDate;  //修改时间
	private BigDecimal useableBalance;  //可用余额
	private Member member;

	public MemberAccount() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="bbin_amount", precision=10, scale=4)
	public BigDecimal getBbinAmount() {
		return this.bbinAmount;
	}

	public void setBbinAmount(BigDecimal bbinAmount) {
		this.bbinAmount = bbinAmount;
	}


	@Column(name="bonus_amount", precision=10, scale=4)
	public BigDecimal getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(BigDecimal bonusAmount) {
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
	public BigDecimal getImusealeBalance() {
		return this.imusealeBalance;
	}

	public void setImusealeBalance(BigDecimal imusealeBalance) {
		this.imusealeBalance = imusealeBalance;
	}


	@Column(name="invest_amount", precision=10, scale=4)
	public BigDecimal getInvestAmount() {
		return this.investAmount;
	}

	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
	}


	@Column(name="total_profit", precision=10, scale=4)
	public BigDecimal getTotalProfit() {
		return this.totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
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
	public BigDecimal getUseableBalance() {
		return this.useableBalance;
	}

	public void setUseableBalance(BigDecimal useableBalance) {
		this.useableBalance = useableBalance;
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

}