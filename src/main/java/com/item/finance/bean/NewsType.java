package com.item.finance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the news_type database table.
 * 
 */
@Entity
@Table(name="news_type")
public class NewsType  {
	
	private int id;
	private int addId;
	private Date addTime;
	private String cPhoto;
	private String info;
	private String link;
	private String name;
	private String note;
	private String pageType;
	private String seoDes;
	private String seoKey;
	private String seoTitle;
	private int sort;
	private int supType;
	private String text;
	private int updId;
	private Date updTime;
	private Set<News> newss = new HashSet<News>();

	public NewsType() {
	}

	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getAddId() {
		return this.addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	@Column(length=100)
	public String getCPhoto() {
		return this.cPhoto;
	}

	public void setCPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}


	@Column(length=500)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	@Column(length=100)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Column(length=50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(length=200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	@Column(length=20)
	public String getPageType() {
		return this.pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}


	@Column(length=500)
	public String getSeoDes() {
		return this.seoDes;
	}

	public void setSeoDes(String seoDes) {
		this.seoDes = seoDes;
	}


	@Column(length=100)
	public String getSeoKey() {
		return this.seoKey;
	}

	public void setSeoKey(String seoKey) {
		this.seoKey = seoKey;
	}


	@Column(length=100)
	public String getSeoTitle() {
		return this.seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public int getSupType() {
		return this.supType;
	}

	public void setSupType(int supType) {
		this.supType = supType;
	}


	@Column(length=500)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int getUpdId() {
		return this.updId;
	}

	public void setUpdId(int updId) {
		this.updId = updId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdTime() {
		return this.updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	@OneToMany(mappedBy="newsType")
	public Set<News> getNews() {
		return this.newss;
	}

	public void setNews(Set<News> newss) {
		this.newss = newss;
	}

}