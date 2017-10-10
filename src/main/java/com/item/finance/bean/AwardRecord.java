package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the award_records database table.
 * 
 */
@Entity
@Table(name="award_records")
public class AwardRecord  {   //奖励记录表
	private int id;
	private Date addTime;  //添加时间
	private BigDecimal amount;  //奖励金额
	private int byinvitingid; //被邀请人id
	//private int invitingid;  //邀请人id
	private int isAward;  //0:未奖励  1：已奖励',
	private int type;  //奖励类型（0：注册奖励，1：投资奖励）
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="invitingid")
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public AwardRecord() {
	}


	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	@Column(precision=10, scale=2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public int getByinvitingid() {
		return this.byinvitingid;
	}

	public void setByinvitingid(int byinvitingid) {
		this.byinvitingid = byinvitingid;
	}

/*
	public int getInvitingid() {
		return this.invitingid;
	}

	public void setInvitingid(int invitingid) {
		this.invitingid = invitingid;
	}
*/

	public int getIsAward() {
		return this.isAward;
	}

	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}