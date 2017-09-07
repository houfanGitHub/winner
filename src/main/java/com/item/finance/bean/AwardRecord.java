package com.item.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the award_records database table.
 * 奖励记录表
 */
@Entity
@Table(name="award_records")
@NamedQuery(name="AwardRecord.findAll", query="SELECT a FROM AwardRecord a")
public class AwardRecord  {
	
	private int id;
	private Date addTime;
	private BigDecimal amount;
	private int byinvitingid;
	private int invitingid;
	private int isAward;
	private int type;

	public AwardRecord() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	public int getInvitingid() {
		return this.invitingid;
	}

	public void setInvitingid(int invitingid) {
		this.invitingid = invitingid;
	}


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