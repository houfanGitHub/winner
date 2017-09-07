package com.item.finance.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the subject_folder database table.
 * 附件归属表
 */
@Entity
@Table(name="subject_folder")
@NamedQuery(name="SubjectFolder.findAll", query="SELECT s FROM SubjectFolder s")
public class SubjectFolder  {

	private String id;
	private Date createDate;
	private Date updateDate;
	private Set<Subject> subjects;
	private Set<SubjectFile> subjectFiles;

	public SubjectFolder() {
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="subjectFolder")
	public Set<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setSubjectFolder(this);

		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setSubjectFolder(null);

		return subject;
	}


	//bi-directional many-to-one association to SubjectFile
	@OneToMany(mappedBy="subjectFolder")
	public Set<SubjectFile> getSubjectFiles() {
		return this.subjectFiles;
	}

	public void setSubjectFiles(Set<SubjectFile> subjectFiles) {
		this.subjectFiles = subjectFiles;
	}

	public SubjectFile addSubjectFile(SubjectFile subjectFile) {
		getSubjectFiles().add(subjectFile);
		subjectFile.setSubjectFolder(this);

		return subjectFile;
	}

	public SubjectFile removeSubjectFile(SubjectFile subjectFile) {
		getSubjectFiles().remove(subjectFile);
		subjectFile.setSubjectFolder(null);

		return subjectFile;
	}

}