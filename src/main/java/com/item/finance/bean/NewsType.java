package com.item.finance.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the news_type database table.
 * 新闻类别列表
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
	private Set<News> newss;

	public NewsType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	public String getCPhoto() {
		return this.cPhoto;
	}

	public void setCPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}


	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getPageType() {
		return this.pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}


	public String getSeoDes() {
		return this.seoDes;
	}

	public void setSeoDes(String seoDes) {
		this.seoDes = seoDes;
	}


	public String getSeoKey() {
		return this.seoKey;
	}

	public void setSeoKey(String seoKey) {
		this.seoKey = seoKey;
	}


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


	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="newsType")
	public Set<News> getNews() {
		return this.newss;
	}

	public void setNews(Set<News> newss) {
		this.newss = newss;
	}

	public News addNew(News news) {
		getNews().add(news);
		news.setNewsType(this);

		return news;
	}

	public News removeNew(News news) {
		getNews().remove(news);
		news.setNewsType(null);

		return news;
	}

}