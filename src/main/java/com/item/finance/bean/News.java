package com.item.finance.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table
public class News  {
	private int id;//序号
	private int addId;//添加id
	private Date addTime;//添加时间
	private int audit;//是否审核
	private String author;//作者
	private int clickNumber;//点击数量
	private String cPhoto;//封面图片
	private String filelink;//附件地址
	private String info;//简介
	private String label;//标签
	private String link;//链接地址
	private int placTop;//是否置顶 0：为是  1为否
	private int recommend;//是否推荐
	private String seoDes;//seo描述
	private String seoKey;//seo关键字
	private String seoTitle;//页面seo标题
	private String source;//来源
	private String subTitle;//副标题
	private String text;//内容
	private String title;//标题
	private int updId;//修改人ID
	private Date updTime;//修改时间
	private NewsType newsType;//咨询类型

	public News() {
	}


	@Id
	@Column(unique=true, nullable=false)
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


	public int getAudit() {
		return this.audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}


	@Column(length=50)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public int getClickNumber() {
		return this.clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}


	@Column(length=100)
	public String getCPhoto() {
		return this.cPhoto;
	}

	public void setCPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}


	@Column(length=200)
	public String getFilelink() {
		return this.filelink;
	}

	public void setFilelink(String filelink) {
		this.filelink = filelink;
	}


	@Column(length=200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	@Column(length=200)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	@Column(length=100)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public int getPlacTop() {
		return this.placTop;
	}

	public void setPlacTop(int placTop) {
		this.placTop = placTop;
	}


	public int getRecommend() {
		return this.recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}


	@Column(length=200)
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


	@Column(length=200)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	@Column(length=200)
	public String getSubTitle() {
		return this.subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	@Lob
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	@Column(length=200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@ManyToOne
	@JoinColumn(name="typeId")
	public NewsType getNewsType() {
		return newsType;
	}


	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}
	public String getcPhoto() {
		return cPhoto;
	}


	public void setcPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}

}