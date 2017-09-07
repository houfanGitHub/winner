package com.item.finance.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the bbin_info database table.
 * 体验金信息表
 */
@Entity
@Table(name="bbin_info")
@NamedQuery(name="BbinInfo.findAll", query="SELECT b FROM BbinInfo b")
public class BbinInfo  {

	private String id;
	private BigDecimal amont;
	private Date createDate;
	private BigInteger status;
	private Date updateDate;
	private Member member;

	public BbinInfo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public BigDecimal getAmont() {
		return this.amont;
	}

	public void setAmont(BigDecimal amont) {
		this.amont = amont;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public BigInteger getStatus() {
		return this.status;
	}

	public void setStatus(BigInteger status) {
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
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}