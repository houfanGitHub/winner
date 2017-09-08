package com.item.finance.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the subject_field_record database table.
 * 
 */
@Entity
@Table(name="subject_field_record")
public class SubjectFieldRecord  {
	private String id;
	private Date createDate;
	private byte delflag;
	private BigInteger fieldId;
	private String fieldValue;
	private Date updateDate;
	private Subject subject;

	public SubjectFieldRecord() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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


	@Column(name="field_id")
	public BigInteger getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(BigInteger fieldId) {
		this.fieldId = fieldId;
	}


	@Column(name="field_value", length=20)
	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_id")
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}