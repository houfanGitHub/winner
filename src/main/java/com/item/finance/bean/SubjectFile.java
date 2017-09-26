package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the subject_file database table.
 * 
 */
@Entity
@Table(name="subject_file")
public class SubjectFile  {
	private int id;
	private String createDate;
	private String fileName;
	private String originalName;//文件名
	private String path;
	private String updateDate;
	private SubjectFolder subjectFolder;

	public SubjectFile() {
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public String getCreateDate() {
		return this.createDate;
	}


	public void setCreateDate(String string) {
		this.createDate = string;
	}


	@Column(name="file_name", length=128)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Column(name="original_name", length=128)
	public String getOriginalName() {
		return this.originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}


	@Column(length=4000)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
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