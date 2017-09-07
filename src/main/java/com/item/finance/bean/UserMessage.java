package com.item.finance.bean;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_message database table.
 * 用户消息表
 */
@Entity
@Table(name="user_message")
@NamedQuery(name="UserMessage.findAll", query="SELECT u FROM UserMessage u")
public class UserMessage  {
	
	private String id;
	private byte businessType;
	private String content;
	private Date createDate;
	private byte delFlag;
	private byte msgStatus;
	private String title;
	private Date updateDate;
	private BigInteger userId;
	private PushNotice pushNotice;

	public UserMessage() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="business_type")
	public byte getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(byte businessType) {
		this.businessType = businessType;
	}


	@Lob
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Column(name="del_flag")
	public byte getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(byte delFlag) {
		this.delFlag = delFlag;
	}


	@Column(name="msg_status")
	public byte getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(byte msgStatus) {
		this.msgStatus = msgStatus;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="user_id")
	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}


	//bi-directional many-to-one association to PushNotice
	@ManyToOne
	@JoinColumn(name="owner_id")
	public PushNotice getPushNotice() {
		return this.pushNotice;
	}

	public void setPushNotice(PushNotice pushNotice) {
		this.pushNotice = pushNotice;
	}

}