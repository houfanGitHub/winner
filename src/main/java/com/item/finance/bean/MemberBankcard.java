package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the member_bankcards database table.
 * 成员银联表
 */
@Entity
@Table(name="member_bankcards")
public class MemberBankcard  { //绑卡表
	private String id;	//ID
	private String cardNo;	//卡号',
	private String cardaddress;	//开户银行所在地
	private Date createDate;	//创建时间
	private byte delflag;	//是否删除（0：正常使用，2：被删除）
	private String type;	//银行卡类型',
	private Date updateDate;	//修改时间
	private Member member;	//用户

	public MemberBankcard() {
	}


	@Id
	@GeneratedValue
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="card_no", length=20)
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	@Column(length=300)
	public String getCardaddress() {
		return this.cardaddress;
	}

	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
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


	@Column(length=50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
	@JoinColumn(name="member_id",unique=true)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	@Override
	public String toString() {
		return "MemberBankcard [id=" + id + ", cardNo=" + cardNo
				+ ", cardaddress=" + cardaddress + ", createDate=" + createDate
				+ ", delflag=" + delflag + ", type=" + type + ", updateDate="
				+ updateDate + ", memberID=" + member.getId() + "]";
	}

}