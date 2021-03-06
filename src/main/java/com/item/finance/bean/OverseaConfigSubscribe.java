package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the oversea_config_subscribe database table.
 * 
 */
@Entity
@Table(name="oversea_config_subscribe")
public class OverseaConfigSubscribe  {
	private int id;//id
	private String addr;//地址
	private Date createDate;//创建时间
	private String name;//姓名
	private String phone;//电话
	private int status;//状态
	private Date updateDate; //修改时间
	private Member member;//会员id
	private OverseaConfig overseaConfig;//海外配置表

	public OverseaConfigSubscribe() {
	}


	/*@Id
	@Column(unique=true, nullable=false)*/
	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(length=200)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(length=200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(length=200)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
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
	@JoinColumn(name="member_id")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	//bi-directional many-to-one association to OverseaConfig
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oversea_id")
	public OverseaConfig getOverseaConfig() {
		return this.overseaConfig;
	}

	public void setOverseaConfig(OverseaConfig overseaConfig) {
		this.overseaConfig = overseaConfig;
	}

}
