package com.item.finance.bean;

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
 * The persistent class for the subject_field_record database table.
 * 主题记录表
 */
@Entity
@Table(name="subject_field_record")
@NamedQuery(name="SubjectFieldRecord.findAll", query="SELECT s FROM SubjectFieldRecord s")
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
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


	@Column(name="field_value")
	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	//bi-directional many-to-one association to Subject
	@ManyToOne
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}