package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the push_notice database table.
 * 
 */
@Entity
@Table(name="push_notice")
public class PushNotice  {
	
	private String id;
	private String content;
	private Date createDate;
	private int status;
	private String title;
	private int PushType;
	private Date update_Date;

	public PushNotice() {
	}


	@Id
	@GeneratedValue
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Column(length=256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdate_Date() {
		return this.update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}


	public int getPushType() {
		return PushType;
	}


	public void setPushType(int pushType) {
		PushType = pushType;
	}
    
}