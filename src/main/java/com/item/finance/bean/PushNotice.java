package com.item.finance.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the push_notice database table.
 * 公告表
 */
@Entity
@Table(name="push_notice")
@NamedQuery(name="PushNotice.findAll", query="SELECT p FROM PushNotice p")
public class PushNotice  {

	private String id;
	private String content;
	private Date createDate;
	private byte status;
	private String title;
	private Date update_Date;
	private Set<UserMessage> userMessages;

	public PushNotice() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}


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


	//bi-directional many-to-one association to UserMessage
	@OneToMany(mappedBy="pushNotice")
	public Set<UserMessage> getUserMessages() {
		return this.userMessages;
	}

	public void setUserMessages(Set<UserMessage> userMessages) {
		this.userMessages = userMessages;
	}

	public UserMessage addUserMessage(UserMessage userMessage) {
		getUserMessages().add(userMessage);
		userMessage.setPushNotice(this);

		return userMessage;
	}

	public UserMessage removeUserMessage(UserMessage userMessage) {
		getUserMessages().remove(userMessage);
		userMessage.setPushNotice(null);

		return userMessage;
	}

}