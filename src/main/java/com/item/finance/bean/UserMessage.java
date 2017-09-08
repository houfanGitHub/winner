package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_message database table.
 * 用户消息表
 */
@Entity
@Table(name="user_message")
public class UserMessage  {
	
	private String id;	//主键
	private byte businessType;	//业务类别
	private String content;	//消息内容
	private Date createDate;	//创建时间
	private byte delFlag;	// 删除标志
	private byte msgStatus;	//状态,(已读未读)
	private String title;	//消息标题
	private Date updateDate;	//修改时间
	private int ownerId;	//业务
	private User user;	//用户

	public UserMessage() {
	}

	@Id
	@GeneratedValue
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
	
	@JoinColumn(name="owner_id")
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name="msg_status")
	public byte getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(byte msgStatus) {
		this.msgStatus = msgStatus;
	}


	@Column(length=128)
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

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}