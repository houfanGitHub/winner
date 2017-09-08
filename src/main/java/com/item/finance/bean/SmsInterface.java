package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the sms_interface database table.
 * 
 */
@Entity
@Table(name="sms_interface")
@NamedQuery(name="SmsInterface.findAll", query="SELECT s FROM SmsInterface s")
public class SmsInterface  {
	private static final long serialVersionUID = 1L;
	private String id;
	private String address;
	private String content;
	private Date createdate;
	private String name;
	private String param;
	private int type;
	private Set<SmsRecord> smsRecords;

	public SmsInterface() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(length=200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(length=2000)
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


	@Column(length=20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(length=200)
	public String getParam() {
		return this.param;
	}

	public void setParam(String param) {
		this.param = param;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}


	//bi-directional many-to-one association to SmsRecord
	@OneToMany(mappedBy="smsInterface")
	public Set<SmsRecord> getSmsRecords() {
		return this.smsRecords;
	}

	public void setSmsRecords(Set<SmsRecord> smsRecords) {
		this.smsRecords = smsRecords;
	}

	public SmsRecord addSmsRecord(SmsRecord smsRecord) {
		getSmsRecords().add(smsRecord);
		smsRecord.setSmsInterface(this);

		return smsRecord;
	}

	public SmsRecord removeSmsRecord(SmsRecord smsRecord) {
		getSmsRecords().remove(smsRecord);
		smsRecord.setSmsInterface(null);

		return smsRecord;
	}

}