package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sms_record database table.
 * 
 */
@Entity
@Table(name="sms_record")
@NamedQuery(name="SmsRecord.findAll", query="SELECT s FROM SmsRecord s")
public class SmsRecord  {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String content;
	private Date createdate;
	private String phone;
	private String result;
	private Date senddate;
	private int status;
	private SmsInterface smsInterface;

	public SmsRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(length=2000)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(length=200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	@Column(length=11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(length=2000)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	//bi-directional many-to-one association to SmsInterface
	@ManyToOne
	@JoinColumn(name="type")
	public SmsInterface getSmsInterface() {
		return this.smsInterface;
	}

	public void setSmsInterface(SmsInterface smsInterface) {
		this.smsInterface = smsInterface;
	}

}