package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the subject_file database table.
 * 附件表
 */
@Entity
@Table(name="subject_file")
@NamedQuery(name="SubjectFile.findAll", query="SELECT s FROM SubjectFile s")
public class SubjectFile  {

	private String id;
	private Date createDate;
	private String fileName;
	private String originalName;
	private String path;
	private Date updateDate;
	private SubjectFolder subjectFolder;

	public SubjectFile() {
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


	@Column(name="file_name")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Column(name="original_name")
	public String getOriginalName() {
		return this.originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}


	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	//bi-directional many-to-one association to SubjectFolder
	@ManyToOne
	@JoinColumn(name="folder_id")
	public SubjectFolder getSubjectFolder() {
		return this.subjectFolder;
	}

	public void setSubjectFolder(SubjectFolder subjectFolder) {
		this.subjectFolder = subjectFolder;
	}

}